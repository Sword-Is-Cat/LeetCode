package Medium.no386;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++)
			dfs(list, i, n);
		return list;
	}

	private void dfs(List<Integer> list, int num, int max) {
		if (num <= max) {
			list.add(num);
			for (int i = 0; i < 10; i++)
				dfs(list, num * 10 + i, max);
		}
	}
}