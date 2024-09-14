package Medium.no2419;

class Solution {
	public int longestSubarray(int[] nums) {

		int max = nums[0];
		for (int num : nums)
			max = Math.max(max, num);

		int cnt = 0, ans = 0;

		for (int num : nums) {
			if (num == max) {
				ans = Math.max(ans, ++cnt);
			} else {
				cnt = 0;
			}
		}

		return ans;
	}
}