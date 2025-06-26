package Medium.no2311;

import java.util.Arrays;

class Solution {

	public int longestSubsequence(String s, int k) {

		char[] arr = s.toCharArray();
		int[] dp = new int[arr.length + 1];
		Arrays.fill(dp, k + 1);
		dp[0] = 0;
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			int digit = arr[i] - '0';
			for (int j = i; j >= 0; j--) {
				int newVal = dp[j] * 2 + digit;
				if (newVal < dp[j + 1]) {
					dp[j + 1] = newVal;
					answer = Math.max(answer, j + 1);
				}
			}
		}

		return answer;
	}
}