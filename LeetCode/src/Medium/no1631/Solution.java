package Medium.no1631;

import java.util.PriorityQueue;

class Solution {
	public int minimumEffortPath(int[][] heights) {

		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int rowMax = heights.length, colMax = heights[0].length;
		boolean[][] visit = new boolean[rowMax][colMax];

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		que.add(new int[] { 0, 0, 0 });
		int effort = 0;

		while (!que.isEmpty()) {

			int[] next = que.poll();
			int row = next[0], col = next[1], eff = next[2];

			if (!visit[row][col]) {

				visit[row][col] = true;
				effort = Math.max(effort, eff);

				if (row + 1 == rowMax && col + 1 == colMax)
					return effort;

				for (int d = 0; d < dir.length; d++) {
					int nRow = row + dir[d][0], nCol = col + dir[d][1];
					if (0 <= nRow && nRow < rowMax && 0 <= nCol && nCol < colMax && !visit[nRow][nCol]) {
						que.add(new int[] { nRow, nCol, Math.abs(heights[nRow][nCol] - heights[row][col]) });
					}
				}

			}
		}
		return -1;
	}
}