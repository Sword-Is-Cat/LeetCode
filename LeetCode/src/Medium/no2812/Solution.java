package Medium.no2812;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int maximumSafenessFactor(List<List<Integer>> grid) {

		int length = grid.size();
		int[][] dist = new int[length][length];
		int[][] visit = new int[length][length];

		Queue<int[]> que = new ArrayDeque<>();
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				if (grid.get(r).get(c) == 1) {
					que.add(new int[] { r, c });
					visit[r][c]++;
				}
			}
		}

		int d = 0;
		while (!que.isEmpty()) {
			int loop = que.size();
			while (loop-- > 0) {
				int[] coord = que.poll();
				dist[coord[0]][coord[1]] = d;
				for (int i = 0; i < dir.length; i++) {
					int nr = coord[0] + dir[i][0], nc = coord[1] + dir[i][1];
					if (isValid(nr, nc, length) && visit[nr][nc] == 0) {
						que.add(new int[] { nr, nc });
						visit[nr][nc]++;
					}
				}
			}
			d++;
		}

		que = new PriorityQueue<>((a, b) -> dist[b[0]][b[1]] - dist[a[0]][a[1]]);
		que.add(new int[] { 0, 0 });
		visit[0][0]++;
		int ans = 2 * length;

		while (!que.isEmpty()) {
			int[] coord = que.poll();
			ans = Math.min(ans, dist[coord[0]][coord[1]]);
			if (coord[0] == length - 1 && coord[1] == length - 1)
				return ans;
			for (int i = 0; i < dir.length; i++) {
				int nr = coord[0] + dir[i][0], nc = coord[1] + dir[i][1];
				if (isValid(nr, nc, length) && visit[nr][nc] == 1) {
					que.add(new int[] { nr, nc });
					visit[nr][nc]++;
				}
			}
		}

		return 0;
	}

	private boolean isValid(int r, int c, int length) {
		return -1 < r && r < length && -1 < c && c < length;
	}

}