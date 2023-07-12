package Medium.no802;

import java.util.ArrayList;
import java.util.List;

class Solution {

	boolean[] calced, isSafe;

	public List<Integer> eventualSafeNodes(int[][] graph) {

		calced = new boolean[graph.length];
		isSafe = new boolean[graph.length];

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			if (isSafeNode(i, graph)) {
				ans.add(i);
			}
		}

		return ans;
	}

	private boolean isSafeNode(int index, int[][] graph) {

		if (!calced[index]) {
			calced[index] = true;

			boolean flag = true;

			for (int conn : graph[index]) {
				flag &= isSafeNode(conn, graph);
			}
			isSafe[index] = flag;

		}
		return isSafe[index];

	}
}