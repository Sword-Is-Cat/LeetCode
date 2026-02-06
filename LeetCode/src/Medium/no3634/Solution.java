package Medium.no3634;

import java.util.Arrays;

class Solution {
	public int minRemoval(int[] nums, int k) {

		int ans = nums.length - 1;
		Arrays.sort(nums);

		int i = 0, j = 0;

		while (++i < nums.length) {
			while ((long) nums[j] * k < nums[i]) {
				j++;
			}

			ans = Math.min(ans, nums.length - i + j - 1);
		}

		return ans;

	}
}