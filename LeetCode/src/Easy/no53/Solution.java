package Easy.no53;

class Solution {
	public int maxSubArray(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		int process = nums[0];
		int max = nums[0];
		int answer = 0;
		
		process = (process>0)?process:0;
		answer = (answer>process)?answer:process;

		for (int i = 1; i < nums.length; i++) {
			process += nums[i];
			max = (max>nums[i])?max:nums[i];
			nums[i] = nums[i - 1] + nums[i];
			process = (process>0)?process:0;
			answer = (answer>process)?answer:process;
			
			System.out.println(process);
		}
		
		return (answer>0)?answer:max;
	}

}