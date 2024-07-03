package Medium.no1509;

import java.util.Arrays;

class Solution {
	public int minDifference(int[] nums) {

		if (nums.length < 4)
			return 0;

		Arrays.sort(nums);

		int dif1 = nums[nums.length - 4] - nums[0];
		int dif2 = nums[nums.length - 3] - nums[1];
		int dif3 = nums[nums.length - 2] - nums[2];
		int dif4 = nums[nums.length - 1] - nums[3];

		return Math.min(Math.min(dif1, dif2), Math.min(dif3, dif4));

	}
}