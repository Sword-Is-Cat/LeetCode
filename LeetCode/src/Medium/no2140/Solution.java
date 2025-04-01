package Medium.no2140;

class Solution {
	public long mostPoints(int[][] questions) {

		int length = questions.length;
		long[] dp = new long[length];
		long prevMax = 0, max = 0;

		for (int i = 0; i < length; i++) {
			prevMax = Math.max(prevMax, dp[i]);
			long point = prevMax + questions[i][0];
			int next = i + questions[i][1] + 1;
			if (next < length) {
				dp[next] = Math.max(dp[next], point);
			} else {
				max = Math.max(max, point);
			}
		}

		return max;
	}
}