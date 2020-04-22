package Easy.no121;

class Solution {
	public int maxProfit(int[] prices) {
		
		if(prices.length == 0)
			return 0;

		int min = prices[0];
		int answer = 0;

		for (int i = 0; i < prices.length; i++) {
			if (min < prices[i])
				answer = (answer > prices[i] - min) ? answer : prices[i] - min;
			else
				min = prices[i];
		}

		return answer;

	}
}