package Medium.no646;

import java.util.Arrays;

class Solution {
	public int findLongestChain(int[][] pairs) {

		int[] dp = new int[pairs.length + 1];
		Arrays.fill(dp, 1001);
		dp[0] = -1001;

		Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int maxLength = 0;

		for (int[] pair : pairs) {
			for (int leng = 0; leng < dp.length; leng++) {
				if (dp[leng] < pair[0]) {
					dp[leng + 1] = Math.min(dp[leng + 1], pair[1]);
					maxLength = Math.max(maxLength, leng + 1);
				}else {
					break;
				}
			}
		}

		return maxLength;
	}
}