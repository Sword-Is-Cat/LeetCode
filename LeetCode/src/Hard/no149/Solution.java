package Hard.no149;

import java.util.HashMap;

class Solution {
	public int maxPoints(int[][] points) {
		int ans = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> counter = new HashMap<>();
			for (int j = i + 1; j < points.length; j++) {
				int[] p1 = points[i], p2 = points[j];
				double mz = 0.0 / -1.0, mi = -1.0 / 0.0;
				double lean = (((double) p2[1] - p1[1]) / (p2[0] - p1[0]));
				if (lean == mz || lean == mi)
					lean = Math.abs(lean);
				counter.compute(lean, (k, v) -> v == null ? 1 : v + 1);
			}
			for (double key : counter.keySet())
				ans = Math.max(ans, counter.get(key));
		}
		return ans + 1;
	}
}