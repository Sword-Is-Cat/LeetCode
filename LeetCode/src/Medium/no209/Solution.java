package Medium.no209;

class Solution {
	public int minSubArrayLen(int target, int[] nums) {

		int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;

		while (right < nums.length || target <= sum) {

			if (sum < target && right < nums.length) {
				sum += nums[right++];
			} else {
				ans = Math.min(ans, right - left);
				sum -= nums[left++];
			}
		}

		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}