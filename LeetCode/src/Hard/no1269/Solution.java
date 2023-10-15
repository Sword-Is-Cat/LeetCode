package Hard.no1269;

class Solution {
	public int numWays(int steps, int arrLen) {

		final int mod = (int) 1e9 + 7;
		arrLen = Math.min(steps / 2 + 1, arrLen);
		int[][] dp = new int[2][arrLen];

		dp[0][0] = 1;
		int slide = 0, prev = 0;

		while (steps-- > 0) {
			prev = slide;
			slide ^= 1;
			for (int i = 0; i < arrLen; i++) {
				dp[slide][i] = dp[prev][i];
				if (0 < i)
					dp[slide][i] = (dp[slide][i] + dp[prev][i - 1]) % mod;
				if (i + 1 < arrLen)
					dp[slide][i] = (dp[slide][i] + dp[prev][i + 1]) % mod;
			}
		}

		return dp[slide][0];
	}
}