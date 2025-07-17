package Medium.no3202;

class Solution {
	public int maximumLength(int[] nums, int k) {

		int answer = 0;
		int[][] dp = new int[k][k];

		for (int num : nums) {
			int r = num % k;
			for (int i = 0; i < k; i++) {
				dp[i][r] = dp[r][i] + 1;
				answer = Math.max(answer, dp[i][r]);
			}
		}

		return answer;

	}
}