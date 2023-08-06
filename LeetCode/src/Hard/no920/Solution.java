package Hard.no920;

class Solution {

	final int MOD = (int) 1e9 + 7;

	public int numMusicPlaylists(int n, int goal, int k) {

		long[][] dp = new long[goal + 1][n + 1];
		dp[0][0] = 1;

		for (int track = 1; track < dp.length; track++) {
			for (int use = 1; use < dp[track].length && use <= track; use++) {

				dp[track][use] = (dp[track - 1][use - 1] * (n - use + 1)) % MOD;
				if (use > k) {
					dp[track][use] = (dp[track][use] + dp[track - 1][use] * (use - k)) % MOD;
				}

			}
		}

		return (int) dp[goal][n];
	}
}