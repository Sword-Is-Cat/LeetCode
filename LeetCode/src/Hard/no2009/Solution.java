package Hard.no2009;

import java.util.Arrays;

class Solution {
	public int minOperations(int[] nums) {

		Arrays.sort(nums);
		int length = nums.length;
		int[] duplCnts = new int[length];

		int ans = length;

		for (int i = 0, j = 1; i < length; i++) {
			for (; j < length && nums[j] < nums[i] + length; j++) {
				duplCnts[j] = duplCnts[j - 1] + (nums[j] == nums[j - 1] ? 1 : 0);
			}
			ans = Math.min(ans, length - j + i + duplCnts[j - 1] - duplCnts[i]);
		}
		return ans;
	}
}