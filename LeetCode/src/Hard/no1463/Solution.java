package Hard.no1463;

import java.util.Arrays;

class Solution {
	public int cherryPickup(int[][] grid) {

		int row = grid.length, col = grid[0].length;
		int[] dir = { -1, 0, 1 };

		int[][][] dp = new int[row][col][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		dp[0][0][col - 1] = grid[0][0] + grid[0][col - 1];
		int ans = 0;

		for (int step = 1; step < row; step++) {
			for (int r1 = 0; r1 < col; r1++) {
				for (int r2 = r1 + 1; r2 < col; r2++) {
					for (int d1 : dir) {
						for (int d2 : dir) {
							int p1 = r1 + d1, p2 = r2 + d2;
							if (0 <= p1 && p1 < col && 0 <= p2 && p2 < col && dp[step - 1][p1][p2] != -1) {

								dp[step][r1][r2] = Math.max(dp[step][r1][r2],
										dp[step - 1][p1][p2] + grid[step][r1] + grid[step][r2]);

								if (step == row - 1) {
									ans = Math.max(ans, dp[step][r1][r2]);
								}

							}
						}
					}
				}
			}
		}

		return ans;
	}
}