package Easy.no283;

class Solution {
	public void moveZeroes(int[] nums) {

		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				count++;
			else
				nums[i - count] = nums[i];
		}

		for (int i = 1; i <= count; i++) {
			nums[nums.length - i] = 0;
		}

	}
}