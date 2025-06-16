package Easy.no2016;

class Solution {
	public int maximumDifference(int[] nums) {

		int answer = -1;
		for (int i = 0, j = 0; j < nums.length; j++) {
			if (nums[j] > nums[i])
				answer = Math.max(answer, nums[j] - nums[i]);
			else
				i = j;
		}

		return answer;
	}
}