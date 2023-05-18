package Medium.no1557;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

		List<Integer> list = new ArrayList<>();
		boolean[] visit = new boolean[n];

		for (List<Integer> edge : edges) {
			visit[edge.get(1)] = true;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i])
				list.add(i);
		}

		return list;
	}

}