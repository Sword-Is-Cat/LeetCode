package Medium.no2755;

import java.util.Arrays;

class Solution {
	public int twoCitySchedCost(int[][] costs) {

		Arrays.sort(costs, (a, b) -> b[1] - b[0] - a[1] + a[0]);

		int cost = 0;

		for (int i = 0; i < costs.length; i++) {

			if (i * 2 < costs.length)
				cost += costs[i][0];
			else
				cost += costs[i][1];

		}
		return cost;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().twoCitySchedCost(
				new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } }));
	}
}