package Easy.no3487;

import java.util.Arrays;

class Solution {
	public int maxSum(int[] nums) {

		Arrays.sort(nums);

		int prev = nums[nums.length - 1], sum = prev;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] != prev && nums[i] > 0) {
				prev = nums[i];
				sum += prev;
			}
		}

		return sum;
	}
}