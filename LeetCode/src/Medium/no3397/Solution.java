package Medium.no3397;

import java.util.Arrays;

class Solution {
	public int maxDistinctElements(int[] nums, int k) {

		Arrays.sort(nums);
		int duplCnt = 0;
		nums[0] -= k;
		for (int i = 1; i < nums.length; i++) {
			int prev = nums[i - 1];
			if (prev == nums[i] + k) {
				duplCnt++;
				nums[i] += k;
			} else {
				nums[i] = Math.max(prev + 1, nums[i] - k);
			}
		}

		return nums.length - duplCnt;
	}
}