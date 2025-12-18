package Medium.no3652;

class Solution {
	public long maxProfit(int[] prices, int[] strategy, int k) {

		long ans = 0;
		for (int i = 0; i < prices.length; i++) {
			ans += prices[i] * strategy[i];
		}

		long temp = ans;
		for (int i = 0; i < k; i++) {
			temp -= prices[i] * strategy[i];
			if (i >= k / 2) {
				temp += prices[i];
			}
		}
		ans = Math.max(ans, temp);

		for (int i = 0; i + k < prices.length; i++) {
			temp += prices[i] * strategy[i];
			temp -= prices[i + (k / 2)];
			temp += prices[i + k] * (1 - strategy[i + k]);
			ans = Math.max(ans, temp);
		}

		return ans;
	}

}