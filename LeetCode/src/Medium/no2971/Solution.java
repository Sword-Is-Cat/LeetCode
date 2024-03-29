package Medium.no2971;

import java.util.Arrays;

class Solution {
	public long largestPerimeter(int[] nums) {

		long sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		Arrays.sort(nums);

		for (int i = nums.length - 1; i > 1; i--) {
			if (sum > nums[i] * 2)
				return sum;
			sum -= nums[i];
		}

		return -1;
	}
}