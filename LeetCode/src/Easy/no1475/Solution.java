package Easy.no1475;

import java.util.Stack;

class Solution {
	public int[] finalPrices(int[] prices) {

		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			int[] price = new int[] { prices[i], i };
			while (!stack.isEmpty() && stack.peek()[0] >= price[0]) {
				prices[stack.pop()[1]] -= price[0];
			}
			stack.push(price);
		}

		return prices;
	}
}