package Easy.no35;

class Solution {
	public int searchInsert(int[] nums, int target) {
		int head = -1, tail = nums.length;
		while (head + 1 < tail) {
			int mid = (head + tail) / 2;
			if (nums[mid] < target)
				head = mid;
			else
				tail = mid;
		}
		return tail;
	}
}