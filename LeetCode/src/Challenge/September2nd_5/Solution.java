package Challenge.September2nd_5;

class Solution {
	public int rob(int[] nums) {

		switch (nums.length) {
		case 0:
			return 0;
		case 1:
			return nums[0];
		case 2:
			return Math.max(nums[0], nums[1]);
		case 3:
			return Math.max(nums[0] + nums[2], nums[1]);
		}

		int[] dp = new int[nums.length];

		dp[0] = nums[0];
		dp[1] = nums[1];
		dp[2] = nums[0]+nums[2];

		for (int i = 3; i < dp.length; i++)
			dp[i] = Math.max(dp[i - 3] + nums[i], dp[i - 2] + nums[i]);

		return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
	}
}