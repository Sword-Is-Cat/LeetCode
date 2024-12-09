package Medium.no3152;

class Solution {
	public boolean[] isArraySpecial(int[] nums, int[][] queries) {

		int[] verify = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			verify[i] = verify[i - 1] + ((nums[i - 1] % 2) ^ (nums[i] % 2) ^ 1);
		}

		boolean[] answer = new boolean[queries.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = verify[queries[i][0]] == verify[queries[i][1]];
		}

		return answer;

	}
}