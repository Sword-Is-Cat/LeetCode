package Medium.no1140;

class Solution {

	public int stoneGameII(int[] piles) {

		int[] rSums = new int[piles.length + 1];
		for (int i = piles.length - 1; 0 <= i; i--)
			rSums[i] = rSums[i + 1] + piles[i];

		int[][] dp = new int[piles.length][piles.length + 1];

		return expect(0, 1, rSums, dp);
	}

	private int expect(int idx, int m, int[] rSums, int[][] dp) {

		if (dp[idx][m] == 0) {

			int value = 0;

			if (dp.length <= idx + 2 * m) {

				value = rSums[idx];
			} else {

				for (int x = 1; x <= 2 * m; x++)
					value = Math.max(value, rSums[idx] - expect(idx + x, Math.max(m, x), rSums, dp));

			}
			dp[idx][m] = value;
		}
		return dp[idx][m];
	}
}