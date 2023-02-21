package Medium.no540;

class Solution {
	public int singleNonDuplicate(int[] nums) {

		int head = 0, tail = nums.length / 2;

		while (head < tail) {
			int mid = (head + tail) / 2;
			if (2 * mid + 1 < nums.length && nums[2 * mid] == nums[2 * mid + 1])
				head = mid + 1;
			else if (2 * mid > 0 && nums[2 * mid - 1] == nums[2 * mid])
				tail = mid - 1;
			else
				return nums[2 * mid];
		}
		return nums[2 * head];
	}
}