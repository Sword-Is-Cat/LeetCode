package Easy.no485;

class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {

		int answer = 0;
		int temp = 0;

		for (int i : nums) {
			if (i == 1)
				temp++;
			else {
				answer = answer < temp ? temp : answer;
				temp = 0;
			}
		}

		answer = answer < temp ? temp : answer;

		return answer;

	}
}