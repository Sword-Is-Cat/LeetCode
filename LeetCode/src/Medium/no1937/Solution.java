package Medium.no1937;

class Solution {
	public long maxPoints(int[][] points) {

		int rowMax = points.length, colMax = points[0].length;
		long[] dp = new long[colMax];

		for (int c = 0; c < colMax; c++)
			dp[c] = points[0][c];

		long[] leftMax, rightMax;

		for (int r = 1; r < rowMax; r++) {

			leftMax = new long[colMax];
			rightMax = new long[colMax];

			leftMax[0] = dp[0];
			for (int c = 1; c < colMax; c++)
				leftMax[c] = Math.max(leftMax[c - 1] - 1, dp[c]);

			rightMax[colMax - 1] = dp[colMax - 1];
			for (int c = colMax - 2; c >= 0; c--)
				rightMax[c] = Math.max(rightMax[c + 1] - 1, dp[c]);

			for (int c = 0; c < colMax; c++)
				dp[c] = Math.max(leftMax[c], rightMax[c]) + points[r][c];

		}
		
		long ans = 0L;

		for (int c = 0; c < colMax; c++)
			ans = Math.max(ans, dp[c]);

		return ans;
	}
}