package Medium.no1658;

class Solution {
	public int minOperations(int[] nums, int x) {

		int left = 0, right = 0, reduce = 0;

		for (int num : nums)
			reduce += num;

		if (reduce == x)
			return nums.length;

		int operation = nums.length + 1;

		while (left <= nums.length && right <= nums.length) {
			if (reduce < x) {
				if (left < nums.length)
					reduce += nums[left++];
				else
					break;
			} else {
				if (right < nums.length)
					reduce -= nums[right++];
				else
					break;
			}
			if (reduce == x)
				operation = Math.min(operation, nums.length + left - right);
		}

		return operation == nums.length + 1 ? -1 : operation;
	}
}
