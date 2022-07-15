package Medium.no695;

class Solution {

	public int maxAreaOfIsland(int[][] grid) {

		int max = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				int val = dfs(row, col, grid);
				max = Math.max(max, val);
			}
		}

		return max;
	}

	int dfs(int row, int col, int[][] grid) {

		int result = 0;

		if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length) {

			if (grid[row][col] == 1) {

				result = 1;
				grid[row][col] = 0;

				result += dfs(row + 1, col, grid);
				result += dfs(row - 1, col, grid);
				result += dfs(row, col + 1, grid);
				result += dfs(row, col - 1, grid);
			}
		}

		return result;
	}
}