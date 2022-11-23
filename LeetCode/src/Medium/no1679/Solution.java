package Medium.no1679;

import java.util.Arrays;

class Solution {
	public int maxOperations(int[] nums, int k) {

		Arrays.sort(nums);
		int cnt = 0;

		int left = 0, right = nums.length - 1;

		while (left < right) {

			if (nums[left] + nums[right] > k) {
				right--;
			} else if (nums[left] + nums[right] < k) {
				left++;
			} else {
				cnt++;
				left++;
				right--;
			}
		}

		return cnt;
	}
}