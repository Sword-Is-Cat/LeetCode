package Easy.no2389;

import java.util.Arrays;

class Solution {
	public int[] answerQueries(int[] nums, int[] queries) {

		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}

		for (int i = 0; i < queries.length; i++) {
			queries[i] = binarySearch(nums, queries[i]);
		}

		return queries;
	}

	int binarySearch(int[] nums, int value) {

		int left = -1, right = nums.length;

		while (right - left > 1) {
			int mid = (left + right) / 2;
			if (value < nums[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}
}