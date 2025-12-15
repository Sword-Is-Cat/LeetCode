package Medium.no2110;

class Solution {
	public long getDescentPeriods(int[] prices) {
		long ans = 0;
		int cnt = 0, prev = prices[0];

		for (int price : prices) {
			if (prev - price == 1) {
				cnt++;
			} else {
				cnt = 1;
			}
			prev = price;
			ans += cnt;
		}

		return ans;
	}
}