package Hard.no1335;

import java.util.Arrays;

class Solution {
	public int minDifficulty(int[] jobDifficulty, int d) {

		if (jobDifficulty.length < d)
			return -1;

		if (jobDifficulty.length == d)
			return Arrays.stream(jobDifficulty).sum();

		int[][] dp = new int[d][jobDifficulty.length];

		dp[0][0] = jobDifficulty[0];
		for (int j = 1; j < jobDifficulty.length; j++)
			dp[0][j] = Math.max(dp[0][j - 1], jobDifficulty[j]);

		for (int day = 1; day < d; day++) {
			for (int j = day; j < jobDifficulty.length; j++) {

				int dayDiff = jobDifficulty[j], daySum = dp[day - 1][j - 1] + dayDiff;

				for (int progress = j - 1; progress >= day - 1; progress--) {

					dayDiff = Math.max(dayDiff, jobDifficulty[progress]);
					daySum = Math.min(daySum, dayDiff + dp[day - 1][progress]);

				}

				dp[day][j] = daySum;

			}
		}

		return dp[d - 1][jobDifficulty.length - 1];
	}
}