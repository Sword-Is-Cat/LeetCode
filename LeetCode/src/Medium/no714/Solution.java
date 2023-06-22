package Medium.no714;

class Solution {
	public int maxProfit(int[] prices, int fee) {

		int buyBal = Integer.MIN_VALUE, sellBal = 0;

		for (int i = 0; i < prices.length; i++) {

			int tempBuy, tempSell;

			tempBuy = sellBal - prices[i];
			tempSell = i > 0 ? buyBal + prices[i] - fee : 0;

			buyBal = Math.max(buyBal, tempBuy);
			sellBal = Math.max(sellBal, tempSell);

		}

		return sellBal;
	}
}