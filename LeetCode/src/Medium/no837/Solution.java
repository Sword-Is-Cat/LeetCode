package Medium.no837;

class Solution {
	public double new21Game(int n, int k, int maxPts) {

		if (k == 0 || k + maxPts - 1 <= n)
			return 1D;

		double[] dp = new double[n + 1];
		dp[0] = 1D;
		double slideSum = dp[0], answer = 0D;

		for (int pt = 1; pt < dp.length; pt++) {

			dp[pt] = slideSum / maxPts;

			if (k <= pt)
				answer += dp[pt];

			if (pt < k)
				slideSum += dp[pt];

			if (0 <= pt - maxPts)
				slideSum -= dp[pt - maxPts];
		}

		return answer;
	}
}