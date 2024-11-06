package Medium.no3011;

class Solution {
	public boolean canSortArray(int[] nums) {

		boolean answer = true;

		for (int i = 1; answer && i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				answer &= Integer.bitCount(nums[i - 1]) == Integer.bitCount(nums[i]);
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}

		for (int i = nums.length - 1; answer && i > 0; i--) {
			if (nums[i - 1] > nums[i]) {
				answer &= Integer.bitCount(nums[i - 1]) == Integer.bitCount(nums[i]);
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}

		return answer;
	}
}