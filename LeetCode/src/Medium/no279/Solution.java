package Medium.no279;

class Solution {
	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		dp[1] = 1;

		for (int num = 2; num <= n; num++) {
			int min = num;
			for (int root = 1; root * root <= num; root++) {
				min = Math.min(min, 1 + dp[num - root * root]);
			}
			dp[num] = min;
		}

		return dp[n];

	}
}