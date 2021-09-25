package Easy.no704;

class Solution {
	public int search(int[] nums, int target) {

		int head = -1;
		int tail = nums.length;

		int mid = -1;

		while (tail - head > 1) {
			mid = (head + tail) / 2;
			if (nums[mid] < target)
				head = mid;
			else
				tail = mid;
		}

		return tail < nums.length && nums[tail] == target ? tail : -1;

	}
}