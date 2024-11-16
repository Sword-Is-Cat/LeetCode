package Medium.no3254;

class Solution {
	public int[] resultsArray(int[] nums, int k) {

		int[] answer = new int[nums.length - k + 1];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = nums[i];
			for (int j = 1; answer[i] != -1 && j < k; j++) {
				answer[i] = nums[i + j - 1] + 1 == nums[i + j] ? nums[i + j] : -1;
			}
		}

		return answer;

	}
}