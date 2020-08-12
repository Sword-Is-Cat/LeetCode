package Easy.no643;

class Solution {
	public double findMaxAverage(int[] nums, int k) {

		int maxSum = 0;
		int temp = 0;
		int i = 0;
		int j = k;

		for (int a = 0; a < k; a++)
			temp += nums[a];

		maxSum = temp;

		while (j < nums.length) {
			temp = temp - nums[i++] + nums[j++];
			maxSum = Math.max(maxSum, temp);
		}
		
		return (double)maxSum/k;

	}
}