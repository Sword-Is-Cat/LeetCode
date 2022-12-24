package Medium.no790;

class Solution {
	public int numTilings(int n) {

		int mod = 1000000007;
		long[] dp = new long[n];

		for (int idx = 0; idx < n; idx++) {
			switch (idx) {
			case 0:
				dp[idx] = 1;
				break;
			case 1:
				dp[idx] = 2;
				break;
			case 2:
				dp[idx] = 5;
				break;
			default:
				dp[idx] = (dp[idx - 1] * 2 + dp[idx - 3]) % mod;

			}
		}
		return (int) dp[n - 1];
	}
}