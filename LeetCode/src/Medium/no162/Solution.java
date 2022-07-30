package Medium.no162;

class Solution {
	public int findPeakElement(int[] nums) {

		int temp = nums[0];
		int idx;

		for (idx = 1; idx < nums.length; idx++) {
			if (temp < nums[idx])
				temp = nums[idx];
			else
				break;
		}

		return idx - 1;
	}
}