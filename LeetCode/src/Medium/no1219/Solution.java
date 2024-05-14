package Medium.no1219;

class Solution {

	int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int getMaximumGold(int[][] grid) {
		int ans = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				ans = Math.max(ans, dfs(grid, row, col));
			}
		}
		return ans;
	}

	private int dfs(int[][] grid, int row, int col) {

		if (row == -1 || row == grid.length || col == -1 || col == grid[row].length || grid[row][col] == 0)
			return 0;

		int currVal = grid[row][col], result = grid[row][col];
		grid[row][col] = 0;

		for (int d = 0; d < dir.length; d++) {
			int nRow = row + dir[d][0], nCol = col + dir[d][1];
			result = Math.max(result, currVal + dfs(grid, nRow, nCol));
		}

		grid[row][col] = currVal;

		return result;
	}
}