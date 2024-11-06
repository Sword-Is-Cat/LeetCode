package Medium.no3011;

class Solution {
	public boolean canSortArray(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				if (Integer.bitCount(nums[i - 1]) != Integer.bitCount(nums[i]))
					return false;
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}

		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] > nums[i]) {
				if (Integer.bitCount(nums[i - 1]) != Integer.bitCount(nums[i]))
					return false;
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}

		return true;
	}
}