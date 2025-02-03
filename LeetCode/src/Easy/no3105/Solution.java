package Easy.no3105;

class Solution {
	public int longestMonotonicSubarray(int[] nums) {
		int ans = 1, inc = 1, dec = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				inc++;
				dec = 1;
			} else if (nums[i - 1] > nums[i]) {
				inc = 1;
				dec++;
			} else {
				inc = dec = 1;
			}
			ans = Math.max(ans, Math.max(inc, dec));
		}
		return ans;
	}
}