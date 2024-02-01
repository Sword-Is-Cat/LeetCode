package Medium.no2966;

import java.util.Arrays;

class Solution {
	public int[][] divideArray(int[] nums, int k) {

		Arrays.sort(nums);
		int[][] ans = new int[nums.length / 3][3];
		for (int i = 0; i < nums.length; i++) {
			ans[i / 3][i % 3] = nums[i];
			if (i % 3 == 2 && nums[i] - nums[i - 2] > k)
				return new int[0][];
		}

		return ans;
	}
}