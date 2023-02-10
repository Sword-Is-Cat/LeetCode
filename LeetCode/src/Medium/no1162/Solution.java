package Medium.no1162;

class Solution {
	public int maxDistance(int[][] grid) {

		int length = grid.length, max = length * 2;

		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				if (grid[row][col] == 1)
					continue;
				int up = row == 0 ? max : grid[row - 1][col];
				int le = col == 0 ? max : grid[row][col - 1];
				grid[row][col] = Math.min(up, le) + 1;
			}
		}

		for (int row = length - 1; row > -1; row--) {
			for (int col = length - 1; col > -1; col--) {
				if (grid[row][col] == 1)
					continue;
				int dn = row == length - 1 ? max : grid[row + 1][col];
				int ri = col == length - 1 ? max : grid[row][col + 1];
				grid[row][col] = Math.min(grid[row][col], Math.min(dn, ri) + 1);
			}
		}

		int ans = -1;
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				ans = Math.max(ans, grid[row][col] - 1);
			}
		}

		return ans > max || ans == 0 ? -1 : ans;
	}
}