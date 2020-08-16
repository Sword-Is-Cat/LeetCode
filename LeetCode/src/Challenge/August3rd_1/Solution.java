package Challenge.August3rd_1;

class Solution {

	public int maxProfit(int[] prices) {

		if (prices.length == 0)
			return 0;

		int firstBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MIN_VALUE;
		int secondSell = 0;

		for (int i : prices) {

			firstBuy = Math.max(firstBuy, -i);
			firstSell = Math.max(firstSell, firstBuy + i);
			secondBuy = Math.max(secondBuy, firstSell - i);
			secondSell = Math.max(secondSell, secondBuy + i);
		}

		return secondSell;
	}
}