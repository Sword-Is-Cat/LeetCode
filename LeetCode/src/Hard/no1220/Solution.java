package Hard.no1220;

import java.util.Arrays;

class Solution {
	public int countVowelPermutation(int n) {

		final int mod = (int) 1e9 + 7;

		int[][] dp = new int[2][5];
		Arrays.fill(dp[0], 1);

		for (int i = 1; i < n; i++) {
			// a after e
			dp[i % 2][0] = dp[(i - 1) % 2][1];
			// e after a i
			dp[i % 2][1] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][2]) % mod;
			// i after a e o u
			dp[i % 2][2] = ((dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1]) % mod
					+ (dp[(i - 1) % 2][3] + dp[(i - 1) % 2][4]) % mod) % mod;
			// o after i u
			dp[i % 2][3] = (dp[(i - 1) % 2][2] + dp[(i - 1) % 2][4]) % mod;
			// u after a
			dp[i % 2][4] = dp[(i - 1) % 2][0];
		}

		int ans = 0;
		ans = (ans + dp[(n - 1) % 2][0]) % mod;
		ans = (ans + dp[(n - 1) % 2][1]) % mod;
		ans = (ans + dp[(n - 1) % 2][2]) % mod;
		ans = (ans + dp[(n - 1) % 2][3]) % mod;
		ans = (ans + dp[(n - 1) % 2][4]) % mod;

		return ans;

	}
}