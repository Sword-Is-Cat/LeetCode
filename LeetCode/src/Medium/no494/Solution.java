package Medium.no494;

class Solution {
	public int findTargetSumWays(int[] nums, int target) {

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum < target || (sum - target) / 2 > sum)
			return 0;

		int[] dp = new int[sum + 1];
		dp[0] = 1;

		for (int num : nums) {
			for (int s = sum - num; s >= 0; s--) {
				dp[s + num] += dp[s];
			}
		}

		return (sum - target) % 2 == 1 ? 0 : dp[(sum - target) / 2];
	}
}