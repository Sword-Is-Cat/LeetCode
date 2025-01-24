package Medium.no802;

import java.util.ArrayList;
import java.util.List;

class Solution {

	boolean[][] cache;

	public List<Integer> eventualSafeNodes(int[][] graph) {

		cache = new boolean[graph.length][2];
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			if (isSafe(i, graph)) {
				ans.add(i);
			}
		}
		return ans;
	}

	private boolean isSafe(int index, int[][] graph) {

		if (!cache[index][0]) {

			cache[index][0] = true;

			boolean flag = true;
			for (int conn : graph[index]) {
				flag &= isSafe(conn, graph);
			}
			cache[index][1] = flag;
		}
		return cache[index][1];
	}
}