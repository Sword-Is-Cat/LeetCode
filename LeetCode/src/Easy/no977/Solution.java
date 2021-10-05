package Easy.no977;

class Solution {
	public int[] sortedSquares(int[] nums) {

		int[] answer = new int[nums.length];

		int minusIndex = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				minusIndex = i - 1;
				break;
			}
		}

		int plusIndex = minusIndex + 1;

		for (int i = 0; i < answer.length; i++)

			if (minusIndex < 0)
				answer[i] = nums[plusIndex] * nums[plusIndex++];

			else if (plusIndex >= answer.length)
				answer[i] = nums[minusIndex] * nums[minusIndex--];

			else if (nums[minusIndex] * nums[minusIndex] > nums[plusIndex] * nums[plusIndex])
				answer[i] = nums[plusIndex] * nums[plusIndex++];

			else
				answer[i] = nums[minusIndex] * nums[minusIndex--];

		return answer;
	}
}