package Medium.no63;

class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length, col = obstacleGrid[0].length;

		int[][] dp = new int[row][col];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (obstacleGrid[r][c] == 1)
					continue;
				if (r == 0 && c == 0)
					dp[r][c] = 1;
				else
					dp[r][c] = (r == 0 ? 0 : dp[r - 1][c]) + (c == 0 ? 0 : dp[r][c - 1]);
			}
		}

		return dp[row - 1][col - 1];
	}
}