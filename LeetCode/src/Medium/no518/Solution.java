package Medium.no518;

class Solution {
	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length][amount + 1];

		for (int i = 0; i < dp[0].length; i++) {
			if (i % coins[0] == 0)
				dp[0][i] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = (coins[i] <= j ? dp[i][j - coins[i]] : 0) + dp[i - 1][j];
			}
		}

		return dp[coins.length - 1][amount];
	}
}