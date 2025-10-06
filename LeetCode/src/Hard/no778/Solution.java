package Hard.no778;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int swimInWater(int[][] grid) {

		int row = grid.length, col = grid[0].length;
		boolean[][] visit = new boolean[row][col];
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> grid[a[0]][a[1]]));
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		queue.offer(new int[] { 0, 0 });
		int answer = 0;

		while (!visit[row - 1][col - 1]) {

			int[] coord = queue.poll();
			int r = coord[0], c = coord[1];

			if (visit[r][c])
				continue;

			answer = Math.max(answer, grid[r][c]);
			visit[r][c] = true;

			for (int d = 0; d < dir.length; d++) {

				int nr = r + dir[d][0], nc = c + dir[d][1];
				if (0 <= nr && nr < row && 0 <= nc && nc < col && !visit[nr][nc]) {
					queue.offer(new int[] { nr, nc });
				}
			}
		}

		return answer;
	}
}