package Hard.no2435;

class Solution {

	static final int MOD = 1_000_000_007;

	public int numberOfPaths(int[][] grid, int k) {

		int row = grid.length, col = grid[0].length;
		int[][][] dp = new int[row][col][k];
		dp[0][0][grid[0][0]%k] = 1;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				for (int m = 0; m < k; m++) {
					if (r > 0) {
						dp[r][c][(m + grid[r][c]) % k] += dp[r - 1][c][m];
					}
					if (c > 0) {
						dp[r][c][(m + grid[r][c]) % k] += dp[r][c - 1][m];
					}
					dp[r][c][(m + grid[r][c]) % k] %= MOD;
				}
			}
		}

		return dp[row - 1][col - 1][0];
	}
}