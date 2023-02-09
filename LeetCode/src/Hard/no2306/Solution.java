package Hard.no2306;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public long distinctNames(String[] ideas) {

		HashMap<Character, HashSet<String>> map = new HashMap<>();

		for (String idea : ideas) {
			map.computeIfAbsent(idea.charAt(0), v -> new HashSet<>()).add(idea.substring(1));
		}

		long ans = 0L;

		for (char key1 : map.keySet()) {
			for (char key2 : map.keySet()) {
				ans += query(map.get(key1), map.get(key2));
			}
		}

		return ans;
	}

	protected int query(HashSet<String> set1, HashSet<String> set2) {

		if (set1.equals(set2))
			return 0;

		HashSet<String> dupl = new HashSet<>(set1);
		dupl.retainAll(set2);
		int duplCnt = dupl.size();

		return (set1.size() - duplCnt) * (set2.size() - duplCnt);
	}
}