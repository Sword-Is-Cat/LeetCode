package Hard.no3363;

class Solution {
	public int maxCollectedFruits(int[][] fruits) {
		int length = fruits.length, answer = 0;
		for (int i = 0; i < length; i++) {
			answer += fruits[i][i];
		}
		int[][] dp = new int[length][length];
		dp[0][length - 1] = fruits[0][length - 1];
		dp[length - 1][0] = fruits[length - 1][0];
		for (int i = 1; i < length - 1; i++) {
			for (int j = Math.max(length - 1 - i, i + 1); j < length; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[j][i] = dp[j][i - 1];
				if (j - 1 >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
					dp[j][i] = Math.max(dp[j][i], dp[j - 1][i - 1]);
				}
				if (j + 1 < length) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1]);
					dp[j][i] = Math.max(dp[j][i], dp[j + 1][i - 1]);
				}
				dp[i][j] += fruits[i][j];
				dp[j][i] += fruits[j][i];
			}
		}
		answer += dp[length - 2][length - 1] += dp[length - 1][length - 2];
		return answer;
	}
}