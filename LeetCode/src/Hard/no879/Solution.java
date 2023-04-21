package Hard.no879;

class Solution {

	final int MOD = (int) Math.pow(10, 9) + 7;
	int[][][] cache;
	int targetProfit;
	int[] group, profits;

	public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

		targetProfit = minProfit;
		this.group = group;
		this.profits = profit;
		cache = new int[n + 1][group.length + 1][];

		return dfs(n, 0)[minProfit];
	}

	private int[] dfs(int member, int index) {

		if (cache[member][index] == null) {

			int[] rst;

			if (index == group.length) {
				// no more crime to do
				rst = new int[targetProfit + 1];
				rst[0] = 1;
			} else {
				// available crime exist

				// [1] default profit: expected profits when skip this crime
				rst = dfs(member, index + 1).clone();

				// [2] commit this crime
				// get crime info
				int need = group[index], profit = profits[index];

				if (need <= member) {
					// check member is enough, get expected profits when commit this crime
					int[] temp = dfs(member - need, index + 1);
					// calculate
					for (int prevProfit = 0; prevProfit < temp.length; prevProfit++) {
						int idx = Math.min(prevProfit + profit, targetProfit);
						rst[idx] += temp[prevProfit];
						rst[idx] %= MOD;
					}
				}
			}
			cache[member][index] = rst;
		}
		return cache[member][index];
	}
}