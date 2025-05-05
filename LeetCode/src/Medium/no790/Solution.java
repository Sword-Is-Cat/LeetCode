package Medium.no790;

class Solution {
	public int numTilings(int n) {

		int mod = (int) 1e9 + 7;
		long[] dp = new long[Math.max(n, 3)];

		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 5;

		for (int idx = 3; idx < n; idx++) {
			dp[idx] = (dp[idx - 1]  * 2 + dp[idx - 3]) % mod;
		}
		return (int) dp[n - 1];
	}
}