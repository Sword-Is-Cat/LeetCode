package Easy.no2016;

class Solution {
	public int maximumDifference(int[] nums) {

		int length = nums.length;
		int[] leftMin = new int[length], rightMax = new int[length];

		leftMin[0] = nums[0];
		for (int i = 1; i < length; i++)
			leftMin[i] = Math.min(leftMin[i - 1], nums[i]);

		rightMax[length - 2] = nums[length - 1];
		for (int i = length - 3; i >= 0; i--)
			rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);

		int answer = rightMax[0] - leftMin[0];
		for (int i = 0; i < length - 1; i++)
			answer = Math.max(answer, rightMax[i] - leftMin[i]);

		return answer <= 0 ? -1 : answer;
	}
}