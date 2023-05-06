package Medium.no1498;

import java.util.Arrays;

class Solution {
	public int numSubseq(int[] nums, int target) {

		Arrays.sort(nums);
		int length = nums.length, MOD = (int) 1e9 + 7;

		int[] pow = new int[length];

		for (int i = 0; i < length; i++)
			pow[i] = i == 0 ? 1 : (pow[i - 1] * 2 % MOD);

		int left = 0, right = length - 1;
		int rst = 0;

		while (left <= right) {

			if (target < nums[left] + nums[right]) {
				right--;
			} else {
				rst += pow[right - left++];
				rst %= MOD;
			}

		}

		return rst;
	}
}