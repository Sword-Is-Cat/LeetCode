package Easy.no2706;

class Solution {
	public int buyChoco(int[] prices, int money) {

		int min1 = 101, min2 = 101;

		for (int price : prices) {
			if (price < min1) {
				min2 = min1;
				min1 = price;
			} else if (price < min2) {
				min2 = price;
			}
		}

		int ans = money - min1 - min2;

		return ans < 0 ? money : ans;

	}
}