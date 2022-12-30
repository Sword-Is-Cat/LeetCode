package Medium.no797;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		ArrayList<List<Integer>> ans = new ArrayList<>();

		dfs(ans, null, 0, graph);

		return ans;

	}

	void dfs(List<List<Integer>> ans, ArrayList<Integer> container, int index, int[][] graph) {

		if (container == null)
			container = new ArrayList<>();

		container.add(index);

		if (index == graph.length - 1)
			ans.add(container);
		else {
			for (int idx : graph[index]) {
				dfs(ans, cloneList(container), idx, graph);
			}
		}
	}

	ArrayList<Integer> cloneList(ArrayList<Integer> list) {
		ArrayList<Integer> newList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			newList.add(list.get(i));
		return newList;
	}
}