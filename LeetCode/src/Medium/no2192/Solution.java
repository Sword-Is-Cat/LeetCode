package Medium.no2192;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> getAncestors(int n, int[][] edges) {

		List<List<Integer>> ans = new ArrayList<>();
		List<List<Integer>> conn = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			ans.add(new ArrayList<>());
			conn.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			conn.get(edge[1]).add(edge[0]);
		}

		for (int i = 0; i < n; i++) {
			dfs(ans, conn, i, i, new boolean[n]);
		}

		for (int i = 0; i < n; i++) {
			ans.get(i).sort(Integer::compareTo);
		}

		return ans;
	}

	private void dfs(List<List<Integer>> ans, List<List<Integer>> conn, int target, int curr, boolean[] visit) {

		visit[curr] = true;
		for (int next : conn.get(curr)) {
			if (!visit[next]) {
				ans.get(target).add(next);
				dfs(ans, conn, target, next, visit);
			}
		}

	}
}