package Easy.no1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

class Solution {
	public boolean uniqueOccurrences(int[] arr) {

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int num : arr) {
			counter.put(num, counter.getOrDefault(num, 0) + 1);
		}

		HashSet<Integer> duplCheck = new HashSet<>();

		for (Entry<Integer, Integer> entry : counter.entrySet()) {
			if (!duplCheck.add(entry.getValue()))
				return false;
		}

		return true;
	}
}