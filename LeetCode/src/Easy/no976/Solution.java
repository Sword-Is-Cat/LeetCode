package Easy.no976;

import java.util.Arrays;

class Solution {
	public int largestPerimeter(int[] nums) {

		Arrays.sort(nums);

		for (int idx = nums.length - 3; idx >= 0; idx--) {

			if (nums[idx] + nums[idx + 1] > nums[idx + 2])
				return nums[idx] + nums[idx + 1] + nums[idx + 2];

		}

		return 0;
	}
}