package Medium.no377;

class Solution {
	public int combinationSum4(int[] nums, int target) {

		int min = nums[0];
		for (int num : nums)
			min = Math.min(min, num);

		int loop = target / min;

		int[][] dp = new int[loop + 1][target + 1];
		dp[0][0] = 1;

		for (int cnt = 1; cnt < dp.length; cnt++) {
			for (int sum = 1; sum < dp[cnt].length; sum++) {
				for (int num : nums) {
					if (num <= sum) {
						dp[cnt][sum] += dp[cnt - 1][sum - num];
					}
				}
			}
		}
		int ans = 0;

		for (int cnt = 0; cnt < dp.length; cnt++) {
			ans += dp[cnt][target];
		}

		return ans;
	}
}