package Medium.no647;

class Solution {

	public int countSubstrings(String s) {

		char[] arr = s.toCharArray();
		boolean[][] dp = new boolean[arr.length][arr.length];

		int ans = 0;

		for (int length = 0; length < arr.length; length++) {
			for (int left = 0; left + length < arr.length; left++) {
				int right = left + length;
				if (length == 0) {
					dp[left][right] = true;
				} else if (length == 1) {
					dp[left][right] = arr[left] == arr[right];
				} else {
					dp[left][right] = arr[left] == arr[right] & dp[left + 1][right - 1];
				}
				if (dp[left][right])
					ans++;
			}
		}

		return ans;
	}

}