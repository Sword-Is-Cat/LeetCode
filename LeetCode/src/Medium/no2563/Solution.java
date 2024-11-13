package Medium.no2563;

import java.util.Arrays;

class Solution {
	public long countFairPairs(int[] nums, int lower, int upper) {
		Arrays.sort(nums);
		long answer = 0;

		for (int i = 0; i < nums.length; i++) {
			int rI = Math.max(binarySearch(nums, upper - nums[i], false), i + 1);
			int lI = Math.max(binarySearch(nums, lower - nums[i], true), i + 1);
			answer += rI - lI;
		}

		return answer;
	}

	private int binarySearch(int[] nums, int target, boolean isInclude) {
		int left = 0, right = nums.length;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				if (isInclude)
					right = mid;
				else
					left = mid;
			else if (nums[mid] < target)
				left = mid;
			else
				right = mid;
		}
		return right;
	}

}