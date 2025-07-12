package Hard.no1900;

class Solution {

	int[][][][] dp = new int[29][29][29][];

	public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
		return dp(n, Math.min(firstPlayer, secondPlayer), Math.max(firstPlayer, secondPlayer));
	}

	private int[] dp(int n, int f, int s) {

		if (dp[n][f][s] != null)
			return dp[n][f][s];

		if (n + 1 == f + s) {
			dp[n][f][s] = new int[] { 1, 1 };
			return dp[n][f][s];
		}

		if (n + 1 < f + s)
			return dp(n, n + 1 - s, n + 1 - f);

		int nextLength = (n + 1) / 2;
		int early = 10, late = 0;

		if (s <= nextLength) {
			for (int i = 0; i < f; i++) {
				for (int j = 0; j < s - f; j++) {
					int[] temp = dp(nextLength, f - i, s - i - j);
					early = Math.min(early, temp[0] + 1);
					late = Math.max(late, temp[1] + 1);
				}
			}
		} else {
			int mirrorS = n + 1 - s;
			int remove = (n - 2 * mirrorS) / 2 + 1;
			for (int i = 0; i < f; i++) {
				for (int j = 0; j < mirrorS - f; j++) {
					int[] temp = dp(nextLength, f - i, s - i - j - remove);
					early = Math.min(early, temp[0] + 1);
					late = Math.max(late, temp[1] + 1);
				}
			}
		}

		dp[n][f][s] = new int[] { early, late };
		return dp[n][f][s];
	}
}