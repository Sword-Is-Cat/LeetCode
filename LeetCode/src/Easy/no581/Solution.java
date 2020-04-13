package Easy.no581;

import java.util.Arrays;

class Solution {
	public int findUnsortedSubarray(int[] nums) {

		int[] numz = nums.clone();
		Arrays.sort(numz);

		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != numz[i])
				break;
			if (i == nums.length - 1)
				return 0;
		}

		int j = 0;
		for (; j < nums.length; j++) {
			if (nums[nums.length - 1 - j] != numz[nums.length - 1 - j])
				break;
		}

		return nums.length - i - j;

	}
}