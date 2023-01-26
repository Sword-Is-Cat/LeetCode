package Medium.no787;

import java.util.ArrayList;

class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		int[][] costs = new int[n][n];
		int[][] bCosts = new int[n][n];
		ArrayList<int[]> data = new ArrayList<>();
		ArrayList<int[]> next = new ArrayList<>();
		for (int[] flight : flights)
			data.add(flight);

		int cycle = 0;

		while (cycle <= k) {

			for (int[] flight : data) {

				int fr = flight[0], to = flight[1], cost = flight[2];

				if (cycle == 0)
					bCosts[fr][to] = cost;

				if (costs[fr][to] == 0 || cost < costs[fr][to]) {

					costs[fr][to] = cost;

					for (int i = 0; i < n; i++) {

						if (i != fr && i != to && bCosts[i][fr] != 0)
							next.add(new int[] { i, to, cost + bCosts[i][fr] });

						if (i != fr && i != to && bCosts[to][i] != 0)
							next.add(new int[] { fr, i, cost + bCosts[to][i] });
					}
				}
			}
			
			data = next;
			next = new ArrayList<>();
			cycle++;
		}

		return costs[src][dst] == 0 ? -1 : costs[src][dst];
	}
}