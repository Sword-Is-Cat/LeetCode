package Medium.no2616;

import java.util.Arrays;

class Solution {
	public int minimizeMax(int[] nums, int p) {

		Arrays.sort(nums);

		int[] diffs = new int[nums.length - 1];

		for (int i = 0; i < diffs.length; i++) {
			diffs[i] = nums[i + 1] - nums[i];
		}

		int left = -1, right = nums[nums.length - 1] - nums[0];

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (count(diffs, mid) < p) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return right;

	}

	private int count(int[] diffs, int diff) {

		int cnt = 0;
		for (int i = 0; i < diffs.length; i++) {
			if (diffs[i] <= diff) {
				cnt++;
				i++;
			}
		}
		return cnt;
	}
}