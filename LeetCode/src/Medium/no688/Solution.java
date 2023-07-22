package Medium.no688;

class Solution {

	int[][] dir = { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -2, 1 }, { -2, -1 }, { -1, 2 }, { -1, -2 } };
	double rate = 1D / 8;

	public double knightProbability(int n, int k, int row, int column) {

		double dp[][][] = new double[k + 1][n][n];

		dp[0][row][column] = 1D;

		for (int i = 0; i < k; i++) {
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (dp[i][r][c] == 0D)
						continue;
					for (int d = 0; d < dir.length; d++) {
						int nr = r + dir[d][0], nc = c + dir[d][1];
						if (isValid(nr, nc, n)) {
							dp[i + 1][nr][nc] += dp[i][r][c] * rate;
						}
					}
				}
			}
		}

		double ans = 0D;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				ans += dp[k][r][c];
			}
		}

		return ans;
	}

	private boolean isValid(int row, int col, int n) {
		return 0 <= row && 0 <= col && row < n && col < n;
	}
}