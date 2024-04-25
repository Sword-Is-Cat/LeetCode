package Medium.no2370;

class Solution {
	public int longestIdealString(String s, int k) {

		int[] dp = new int[26];
		char[] arr = s.toCharArray();
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			int temp = 0, ch = arr[i] - 'a';
			int min = Math.max(ch - k, 0), max = Math.min(ch + k, 25);
			for (int j = min; j <= max; j++) {
				temp = Math.max(temp, dp[j]);
			}
			dp[ch] = temp + 1;
			ans = Math.max(ans, temp + 1);
		}

		return ans;
	}
}