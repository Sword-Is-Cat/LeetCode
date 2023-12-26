package Medium.no1155;

import java.util.Arrays;

class Solution {

	final int mod = (int) 1e9 + 7;
	int dp[][], maxDice;

	public int numRollsToTarget(int n, int k, int target) {

		dp = new int[n + 1][target + 1];
		for (int i = 1; i < dp.length; i++)
			Arrays.fill(dp[i], -1);

		maxDice = k;

		return dp(n, target);
	}

	private int dp(int dice, int value) {

		if (dice == 0 && value == 0)
			return 1;

		if (dice <= 0 || value <= 0)
			return 0;

		if (dp[dice][value] == -1) {
			int count = 0;
			for (int i = 1; i <= maxDice; i++) {
				count = (count + dp(dice - 1, value - i)) % mod;
			}
			dp[dice][value] = count;
		}

		return dp[dice][value];
	}

}