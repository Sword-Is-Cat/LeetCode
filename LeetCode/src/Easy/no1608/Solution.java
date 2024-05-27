package Easy.no1608;

import java.util.Arrays;

class Solution {
	public int specialArray(int[] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		for (int i = 1; i < length; i++) {
			if (nums[length - i] >= i && nums[length - i - 1] < i) {
				return i;
			}
		}
		if(nums[0]>=length) {
			return length;
		}
		return -1;
	}
}