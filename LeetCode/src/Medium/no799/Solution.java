package Medium.no799;

class Solution {
	public double champagneTower(int poured, int query_row, int query_glass) {

		double[][] dp = new double[query_row + 1][];

		for (int i = 0; i < dp.length; i++)
			dp[i] = new double[i + 1];

		dp[0][0] = poured;

		for (int row = 1; row < dp.length; row++) {
			for (int col = 0; col < dp[row].length; col++) {
				double result = 0D;
				if (col > 0)
					result += Math.max(dp[row - 1][col - 1] - 1D, 0D);
				if (col < row)
					result += Math.max(dp[row - 1][col] - 1D, 0D);
				dp[row][col] = result / 2D;
			}
		}

		return Math.min(dp[query_row][query_glass], 1D);
	}
}