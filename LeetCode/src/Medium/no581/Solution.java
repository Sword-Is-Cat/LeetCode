package Medium.no581;

class Solution {
	public int findUnsortedSubarray(int[] nums) {

		boolean flag = false;
		int min = 100001;

		for (int i = 0; i < nums.length; i++) {

			if (flag) {
				min = Math.min(min, nums[i]);
			} else if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
				flag = true;
			}
		}

		if (min == 100001)
			return 0;

		int left = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > min) {
				left = i;
				break;
			}
		}

		flag = false;
		int max = -100001;

		for (int i = nums.length - 1; i >= 0; i--) {

			if (flag) {
				max = Math.max(max, nums[i]);
			} else if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
				flag = true;
			}
		}

		int right = nums.length;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < max) {
				right = i;
				break;
			}
		}

		return right - left + 1;
	}
}