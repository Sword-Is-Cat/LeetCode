package Medium.no1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {

		List<List<Integer>> ans = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int idx = 0; idx < groupSizes.length; idx++) {

			int size = groupSizes[idx];

			if (!map.containsKey(size)) {
				map.put(size, new ArrayList<>());
				ans.add(map.get(size));
			}

			map.get(size).add(idx);

			if (map.get(size).size() == size) {
				map.remove(size);
			}

		}

		return ans;
	}
}