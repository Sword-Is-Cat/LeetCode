package Medium.no91;

class Solution {
	public int numDecodings(String s) {

		char[] arr = s.toCharArray();
		int[] dp = new int[arr.length + 1];
		dp[0] = 1;

		for (int i = 0; i < arr.length; i++) {

			int curr = arr[i] - '0';
			if (0 < curr && curr < 10)
				dp[i + 1] = dp[i];

			if (0 < i) {
				int prev = arr[i - 1] - '0';
				if (9 < prev * 10 + curr && prev * 10 + curr < 27) {
					dp[i + 1] += dp[i - 1];
				}
			}

		}

		return dp[dp.length - 1];
	}
}