package Medium.no2492;

import java.util.HashMap;

class Solution {

	int ans = Integer.MAX_VALUE, cityCnt;
	HashMap<Integer, HashMap<Integer, Integer>> map;
	boolean[] visit;

	public int minScore(int n, int[][] roads) {

		visit = new boolean[n + 1];
		map = new HashMap<>();
		cityCnt = n;

		for (int[] road : roads) {
			int city1 = road[0], city2 = road[1], distance = road[2];
			map.computeIfAbsent(city1, v -> new HashMap<>()).put(city2, distance);
			map.computeIfAbsent(city2, v -> new HashMap<>()).put(city1, distance);
		}

		visitCity(1);

		return ans;
	}

	protected void visitCity(int cityNo) {
		if (!visit[cityNo]) {
			visit[cityNo] = true;

			for (int nextCity : map.get(cityNo).keySet()) {

				int d = map.get(cityNo).get(nextCity);
				if (d > 0) {
					ans = Math.min(ans, d);
					visitCity(nextCity);
				}
			}
		}
	}
}