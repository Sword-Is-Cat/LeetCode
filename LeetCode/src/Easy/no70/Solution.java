package Easy.no70;

class Solution {
	public int climbStairs(int n) {

		int[] dp = new int[n + 1];

		for (int step = 0; step <= n; step++)
			dp[step] = step < 2 ? 1 : (dp[step - 1] + dp[step - 2]);

		return dp[n];
	}
}