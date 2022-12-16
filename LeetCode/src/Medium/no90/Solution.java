package Medium.no90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	HashMap<Integer, Integer> counter = new HashMap<>();
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		for (int num : nums) {
			if (!counter.containsKey(num))
				counter.put(num, 0);
			counter.put(num, counter.get(num) + 1);
		}

		int[] keys = new int[counter.keySet().size()], cnts = new int[keys.length];

		int idx = 0;
		for (int key : counter.keySet())
			keys[idx++] = key;

		dfs(keys, cnts, 0);

		return ans;

	}

	void dfs(int[] keys, int[] cnts, int idx) {

		if (idx == keys.length) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < keys.length; i++) {
				for (int cnt = 0; cnt < cnts[i]; cnt++) {
					list.add(keys[i]);
				}
			}
			ans.add(list);
		} else {

			for (int cnt = 0; cnt <= counter.get(keys[idx]); cnt++) {

				dfs(keys, cnts, idx + 1);
				cnts[idx]++;

			}
			cnts[idx] = 0;
		}
	}
}