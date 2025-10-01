package Medium.no1039;

import java.util.HashMap;

class Solution {

	int length, vals[];
	HashMap<Integer, Integer> cache = new HashMap<>();

	public int minScoreTriangulation(int[] values) {
		vals = values;
		length = values.length;
		return proc(0, length - 1);
	}

	int proc(int from, int to) {
		if (from + 1 == to)
			return 0;
		if (from + 2 == to)
			return vals[from] * vals[from + 1] * vals[from + 2];
		int key = from * length + to;
		if (!cache.containsKey(key)) {
			int rst = Integer.MAX_VALUE;
			for (int mid = from + 1; mid < to; mid++) {
				rst = Math.min(rst, vals[from] * vals[mid] * vals[to] + proc(from, mid) + proc(mid, to));
			}
			cache.put(key, rst);
		}
		return cache.get(key);
	}
}