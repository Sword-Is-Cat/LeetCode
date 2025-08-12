package Medium.no2787;

class Solution {
	
	private final int MOD = 1_000_000_007;

	public int numberOfWays(int n, int x) {
		int length = x == 1 ? 300 : x == 2 ? 17 : x == 3 ? 6 : x == 4 ? 4 : x == 5 ? 3 : -1;
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = i + 1;
		while (x > 1) {
			for (int i = 0; i < length; i++)
				nums[i] *= i + 1;
			x--;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int v = dp.length - 1; v >= 0; v--) {
				if (v + num < dp.length) {
					dp[v + num] = (dp[v + num] + dp[v]) % MOD;
				}
			}
		}
		return dp[n];
	}
}