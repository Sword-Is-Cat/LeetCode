package Easy.no3392;

class Solution {
	public int countSubarrays(int[] nums) {

		int answer = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i + 1] == (nums[i] + nums[i + 2]) * 2)
				answer++;
		}

		return answer;

	}
}