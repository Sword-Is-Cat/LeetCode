package Medium.no1162;

class Solution {
	public int maxDistance(int[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (grid[row][col] == 1) {
					query(grid, row, col, 1);
				}
			}
		}

		int max = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				max = Math.max(max, grid[row][col]);
			}
		}

		return max - (max == 1 ? 2 : 1);

	}

	protected void query(int[][] grid, int row, int col, int val) {
		if (row < 0 || col < 0 || row == grid.length || col == grid.length)
			return;

		if (grid[row][col] == 0 || val == 1 || grid[row][col] > val) {

			grid[row][col] = val;
			query(grid, row + 1, col, val + 1);
			query(grid, row - 1, col, val + 1);
			query(grid, row, col + 1, val + 1);
			query(grid, row, col - 1, val + 1);
		}
	}
}