package Easy.no2529;

class Solution {
	public int maximumCount(int[] nums) {

		return Math.max(findIndexOfGreater(nums, 0, true), nums.length - findIndexOfGreater(nums, 0, false));

	}

	private int findIndexOfGreater(int[] array, int value, boolean inclusive) {

		int left = -1, right = array.length;

		while (left + 1 < right) {

			int mid = (left + right) / 2;

			if (array[mid] > value || (inclusive && array[mid] == value)) {
				right = mid;
			} else {
				left = mid;
			}
		}

		return right;

	}
}