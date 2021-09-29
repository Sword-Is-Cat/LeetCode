package Easy.no922;

class Solution {
	public int[] sortArrayByParityII(int[] nums) {

		int[] answer = new int[nums.length];
		int even = 0;
		int odd = 1;

		for (int no : nums) {
			if (no % 2 == 0) {
				answer[even] = no;
				even += 2;
			} else {
				answer[odd] = no;
				odd += 2;
			}
		}

		return answer;
	}
}