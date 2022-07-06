package Medium.no785;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public boolean isBipartite(int[][] graph) {

		Set<Integer> left = new HashSet<>(), right = new HashSet<>();

		for (int i = 0; i < graph.length; i++)
			if (!left.contains(i) && !right.contains(i))
				dfs(left, right, graph, i);

		left.retainAll(right);

		return left.isEmpty();
	}

	void dfs(Set<Integer> curSet, Set<Integer> nextSet, int[][] graph, int idx) {

		if (curSet.add(idx)) {

			for (int no : graph[idx]) {
				dfs(nextSet, curSet, graph, no);
			}
		}
	}
}