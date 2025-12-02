package Medium.no3623;

import java.util.HashMap;

class Solution {
	public int countTrapezoids(int[][] points) {

		HashMap<Integer, Integer> counter = new HashMap<>();
		int MOD = 1_000_000_007;

		for (int[] point : points) {
			int y_pos = point[1];
			counter.put(y_pos, counter.getOrDefault(y_pos, 0) + 1);
		}

		long ans = 0, lines = 0, lineSum = 0;
		for (int cnt : counter.values()) {
			lines = (long) cnt * (cnt - 1) / 2;
			ans = (ans + lines * lineSum) % MOD;
			lineSum = (lineSum + lines) % MOD;
		}

		return (int) ans;
	}
}