package Easy.no2154;

import java.util.Arrays;

class Solution {
	public int findFinalValue(int[] nums, int original) {
		Arrays.sort(nums);
		for (int num : nums) {
			if (num == original) {
				original *= 2;
			}
		}
		return original;
	}
}