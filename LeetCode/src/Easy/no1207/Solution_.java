package Easy.no1207;

import java.util.HashMap;
import java.util.HashSet;

class Solution_ {
	public boolean uniqueOccurrences(int[] arr) {

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int no : arr) {
			if (!counter.containsKey(no))
				counter.put(no, 0);
			counter.put(no, counter.get(no) + 1);
		}

		HashSet<Integer> duplChecker = new HashSet<>();
		boolean ans = true;

		for (int key : counter.keySet()) {
			if (ans) {
				ans &= duplChecker.add(counter.get(key));
			}
		}

		return ans;
	}
}