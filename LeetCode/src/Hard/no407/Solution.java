package Hard.no407;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int trapRainWater(int[][] heightMap) {

		int ans = 0;

		Queue<int[]> que = new PriorityQueue<>(Comparator.comparing(a -> heightMap[a[0]][a[1]]));
		boolean[][] visit = new boolean[heightMap.length][heightMap[0].length];

		for (int i = 0; i < heightMap.length; i++) {
			for (int j = 0; j < heightMap[i].length; j++) {
				if (i == 0 || j == 0 || i == heightMap.length - 1 || j == heightMap[i].length - 1) {
					visit[i][j] = true;
					que.offer(new int[] { i, j });
				}
			}
		}

		while (!que.isEmpty()) {
			int[] coord = que.poll();
			int r = coord[0], c = coord[1];
			for (int d = 0; d < dir.length; d++) {
				int nr = r + dir[d][0], nc = c + dir[d][1];
				if (nr >= 0 && nc >= 0 && nr < heightMap.length && nc < heightMap[nr].length && !visit[nr][nc]) {
					if (heightMap[nr][nc] < heightMap[r][c]) {
						ans += heightMap[r][c] - heightMap[nr][nc];
						heightMap[nr][nc] = heightMap[r][c];
					}
					visit[nr][nc] = true;
					que.offer(new int[] { nr, nc });
				}
			}
		}

		return ans;
	}
}