package Hard.no778;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int swimInWater(int[][] grid) {

		int len = grid.length;
		boolean[][] visit = new boolean[len][len];
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> grid[a[0]][a[1]]));
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		queue.offer(new int[] { 0, 0 });
		visit[0][0] = true;
		int answer = 0;

		while (!visit[len - 1][len - 1]) {

			int[] co = queue.poll();
			int r = co[0], c = co[1];

			answer = Math.max(answer, grid[r][c]);

			for (int d = 0; d < dir.length; d++) {

				int nr = r + dir[d][0], nc = c + dir[d][1];
				if (0 <= nr && nr < len && 0 <= nc && nc < len && !visit[nr][nc]) {
					queue.offer(new int[] { nr, nc });
					visit[nr][nc] = true;
				}
			}
		}

		return Math.max(answer, grid[len - 1][len - 1]);
	}
}