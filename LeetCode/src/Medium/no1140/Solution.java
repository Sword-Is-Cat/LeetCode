package Medium.no1140;

class Solution {

	int length;
	int[] rSums;
	int[][] dp;

	public int stoneGameII(int[] piles) {

		length = piles.length;

		rSums = new int[length + 1];
		for (int i = length - 1; 0 <= i; i--)
			rSums[i] = rSums[i + 1] + piles[i];

		dp = new int[length][length + 1];

		return expect(0, 1);
	}

	private int expect(int idx, int m) {

		if (dp[idx][m] == 0) {

			int value = 0;

			if (length <= idx + 2 * m) {

				value = rSums[idx];
			} else {

				for (int x = 1; x <= 2 * m; x++)
					value = Math.max(value, rSums[idx] - expect(idx + x, Math.max(m, x)));

			}
			dp[idx][m] = value;
		}
		return dp[idx][m];
	}
}