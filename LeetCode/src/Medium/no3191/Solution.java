package Medium.no3191;

class Solution {
	public int minOperations(int[] nums) {

		int flip = 0, length = nums.length;

		for (int i = 0; i < length - 2; i++) {
			if (nums[i] == 0) {
				flip++;
				nums[i] ^= 1;
				nums[i + 1] ^= 1;
				nums[i + 2] ^= 1;
			}
		}

		if (nums[length - 2] == 1 && nums[length - 1] == 1)
			return flip;

		return -1;

	}
}