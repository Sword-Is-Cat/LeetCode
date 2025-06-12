package Easy.no3423;

class Solution {
	public int maxAdjacentDistance(int[] nums) {
		int ans = Math.abs(nums[0] - nums[nums.length - 1]);
		for (int i = 1; i < nums.length; i++) {
			ans = Math.max(ans, Math.abs(nums[i] - nums[i - 1]));
		}
		return ans;
	}
}