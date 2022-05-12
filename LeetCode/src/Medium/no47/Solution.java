package Medium.no47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	List<List<Integer>> list;

	public List<List<Integer>> permuteUnique(int[] nums) {

		list = new ArrayList<>();
		Map<Integer, Integer> counter = new HashMap<>();

		for (int num : nums) {
			if (!counter.containsKey(num))
				counter.put(num, 0);
			counter.put(num, counter.get(num) + 1);
		}

		permutation(counter, new ArrayList<>(), 0, nums.length);

		return list;
	}

	void permutation(Map<Integer, Integer> counter, List<Integer> permute, int index, int goal) {

		if (index == goal) {
			list.add(new ArrayList<>(permute));
		} else {

			for (int key : counter.keySet()) {

				if (counter.get(key) > 0) {
					counter.put(key, counter.get(key) - 1);

					permute.add(key);

					permutation(counter, permute, index + 1, goal);

					permute.remove(index);

					counter.put(key, counter.get(key) + 1);
				}

			}

		}

	}
}