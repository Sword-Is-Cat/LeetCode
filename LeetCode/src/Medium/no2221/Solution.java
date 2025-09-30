package Medium.no2221;

class Solution {
	public int triangularSum(int[] nums) {
		for (int cycle = 1; cycle < nums.length; cycle++) {
			for (int i = 0; i + cycle < nums.length; i++) {
				nums[i] = (nums[i] + nums[i + 1]) % 10;
			}
		}
		return nums[0];
	}
}