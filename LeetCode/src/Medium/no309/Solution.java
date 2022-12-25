package Medium.no309;

class Solution {
	public int maxProfit(int[] prices) {

		if (prices.length < 2)
			return 0;

		int money = Integer.MIN_VALUE;
		int[] dp = new int[prices.length];

		for (int day = 0; day < prices.length; day++) {

			dp[day] = day == 0 ? 0 : Math.max(money + prices[day], dp[day - 1]);
			money = Math.max(money, (day > 1 ? dp[day - 2] : 0) - prices[day]);

		}

		return dp[prices.length - 1];
	}
}