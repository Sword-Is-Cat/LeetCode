package Hard.no1547;

import java.util.Arrays;

class Solution {

	int[] cut;
	int[][] dp;

	public int minCost(int n, int[] cuts) {

		cut = new int[cuts.length + 2];

		for (int i = 0; i < cuts.length; i++)
			cut[i] = cuts[i];

		cut[cut.length - 2] = 0;
		cut[cut.length - 1] = n;

		Arrays.sort(cut);

		dp = new int[cut.length][cut.length];

		return getDpValue(0, cut.length - 1);

	}

	private int getDpValue(int n, int m) {

		if (n + 1 == m)
			return 0;

		if (dp[n][m] == 0) {

			dp[n][m] = cut[m] - cut[n];

			int value = Integer.MAX_VALUE;

			for (int next = n + 1; next < m; next++)
				value = Math.min(value, getDpValue(n, next) + getDpValue(next, m));

			dp[n][m] += value;

		}
		return dp[n][m];
	}
}