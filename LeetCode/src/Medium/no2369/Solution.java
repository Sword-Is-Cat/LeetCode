package Medium.no2369;

class Solution {
	public boolean validPartition(int[] nums) {

		boolean[] dp = new boolean[nums.length];
		dp[1] = nums[0] == nums[1];
		if (dp.length > 2)
			dp[2] = (nums[0] == nums[1] && nums[1] == nums[2]) || (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2]);

		for (int i = 3; i < dp.length; i++) {
			dp[i] |= dp[i - 2] && nums[i - 1] == nums[i];
			dp[i] |= dp[i - 3] && (nums[i - 2] == nums[i - 1] && nums[i - 1] == nums[i]);
			dp[i] |= dp[i - 3] && (nums[i - 2] + 1 == nums[i - 1] && nums[i - 1] + 1 == nums[i]);

		}

		return dp[dp.length - 1];
	}
}