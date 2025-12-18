package Medium.no3573;

class Solution {

	private int[] prices;
	private long[][][] cache;

	public long maximumProfit(int[] prices, int k) {
		this.prices = prices;
		int length = prices.length;
		cache = new long[length][k + 1][3];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j <= k; j++) {
				for (int s = 0; s < 3; s++) {
					cache[i][j][s] = -1;
				}
			}
		}
		return dfs(length - 1, k, 0);
	}

	private long dfs(int i, int j, int state) {
		if (j == 0) {
			return 0;
		}
		if (i == 0) {
			return state == 0 ? 0 : (state == 1 ? -prices[0] : prices[0]);
		}
		if (cache[i][j][state] != -1) {
			return cache[i][j][state];
		}

		int p = prices[i];
		long result = 0;
		switch (state) {
		case 0:
			result = Math.max(dfs(i - 1, j, 0), Math.max(dfs(i - 1, j, 1) + p, dfs(i - 1, j, 2) - p));
			break;
		case 1:
			result = Math.max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - p);
			break;
		case 2:
			result = Math.max(dfs(i - 1, j, 2), dfs(i - 1, j - 1, 0) + p);
			break;
		}
		cache[i][j][state] = result;
		return result;
	}
}