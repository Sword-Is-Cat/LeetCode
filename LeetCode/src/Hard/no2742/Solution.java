package Hard.no2742;

class Solution {

	int[] cost, time;
	int[][] dp;
	int burstCost = (int) 1e9;

	public int paintWalls(int[] cost, int[] time) {

		this.cost = cost;
		this.time = time;
		dp = new int[cost.length][cost.length];

		return calcDp(0, 0);
	}

	private int calcDp(int index, int painted) {

		if (painted >= cost.length)
			return 0;

		if (index == cost.length)
			return burstCost;

		if (dp[index][painted] == 0) {

			int costWhenPaint = cost[index] + calcDp(index + 1, painted + 1 + time[index]);
			int costWhenNotPaint = calcDp(index + 1, painted);

			dp[index][painted] = Math.min(costWhenPaint, costWhenNotPaint);
		}

		return dp[index][painted];
	}
}