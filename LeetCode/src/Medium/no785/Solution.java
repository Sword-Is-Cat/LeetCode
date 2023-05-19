package Medium.no785;

class Solution {

	int[] position;

	public boolean isBipartite(int[][] graph) {

		position = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			if (position[i] == 0) {
				if (!setValue(graph, i, 1))
					return false;
			}
		}
		return true;
	}

	private boolean setValue(int[][] graph, int idx, int val) {

		if (position[idx] == 0) {

			position[idx] = val;

			for (int next : graph[idx]) {
				if (!setValue(graph, next, val * -1))
					return false;
			}
			return true;
		} else {
			return position[idx] == val;
		}
	}
}