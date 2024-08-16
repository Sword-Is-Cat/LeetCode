package Medium.no624;

import java.util.List;

class Solution {
	public int maxDistance(List<List<Integer>> arrays) {

		int ans = 0;
		int min = 10000, max = -10000;

		for (List<Integer> list : arrays) {
			ans = Math.max(ans, max - list.get(0));
			ans = Math.max(ans, list.get(list.size() - 1) - min);
			min = Math.min(min, list.get(0));
			max = Math.max(max, list.get(list.size() - 1));
		}

		return ans;

	}
}