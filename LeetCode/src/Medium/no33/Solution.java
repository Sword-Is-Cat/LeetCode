package Medium.no33;

class Solution {

	public int search(int[] nums, int target) {

		int prev = findRotatePoint(nums) + 1;

		int left = 0;
		int right = nums.length;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (nums[(mid + prev) % nums.length] > target)
				right = mid;
			else
				left = mid;
		}

		return nums[(left + prev) % nums.length] == target ? (left + prev) % nums.length : -1;
	}

	int findRotatePoint(int[] nums) {

		int left = 0;
		int right = nums.length;

		while (left + 1 < right) {

			int mid = (left + right) / 2;

			if (nums[left] < nums[mid])
				left = mid;
			else
				right = mid;

		}

		return left;
	}
}