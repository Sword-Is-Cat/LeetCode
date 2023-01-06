package Medium.no1833;

import java.util.Arrays;

class Solution {
	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		for (int i = 0; i < costs.length; i++) {
			coins -= costs[i];
			if (0 > coins)
				return i;
		}
		return costs.length;
	}
}