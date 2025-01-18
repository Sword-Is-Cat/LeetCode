package Hard.no1368;

import java.util.Arrays;

class Solution {

	int[][] dir = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int minCost(int[][] grid) {

		int rowLen = grid.length, colLen = grid[0].length;

		int[][] minChange = new int[rowLen][colLen];
		for (int[] row : minChange)
			Arrays.fill(row, rowLen * colLen);

		areaSearch(0, 0, 0, grid, minChange);

		return minChange[rowLen - 1][colLen - 1];
	}

	private void areaSearch(int r, int c, int change, int[][] grid, int[][] minChange) {
		if (r < 0 || c < 0 || r == grid.length || c == grid[r].length)
			return;

		if (minChange[r][c] > change) {
			minChange[r][c] = change;
			int[] direct = dir[grid[r][c]];
			areaSearch(r + direct[0], c + direct[1], change, grid, minChange);
			for (int d = 1; d < dir.length; d++) {
				areaSearch(r + dir[d][0], c + dir[d][1], change + 1, grid, minChange);
			}
		}
	}
}
