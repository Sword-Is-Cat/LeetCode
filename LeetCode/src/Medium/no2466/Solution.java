package Medium.no2466;

class Solution {
	public int countGoodStrings(int low, int high, int zero, int one) {

		int[] dp = new int[high + 1];
		dp[0] = 1;
		int MOD = (int) 1e9 + 7;

		int sum = 0;

		for (int i = 1; i < dp.length; i++) {

			if (zero <= i)
				dp[i] += dp[i - zero];
			if (one <= i)
				dp[i] += dp[i - one];

			dp[i] %= MOD;

			if (low <= i)
				sum += dp[i];
			sum %= MOD;

		}

		return sum;
	}
}