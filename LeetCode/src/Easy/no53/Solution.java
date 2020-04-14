package Easy.no53;

class Solution {
	public int maxSubArray(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		int process = 0;
		int max = 0;
		int answer = 0;

		for (int i = 0; i < nums.length; i++) {
			process += nums[i];
			process = (process > 0) ? process : 0;
			answer = (answer > process) ? answer : process;
			if (i == 0)
				max = nums[0];
			else {
				max = (max > nums[i]) ? max : nums[i];
				nums[i] = nums[i - 1] + nums[i];
			}
		}
		return (answer > 0) ? answer : max;
	}
}