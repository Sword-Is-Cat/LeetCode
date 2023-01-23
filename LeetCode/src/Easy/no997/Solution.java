package Easy.no997;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int findJudge(int n, int[][] trust) {

		if (n == 1)
			return 1;

		HashMap<Integer, HashSet<Integer>> trusting = new HashMap<>();
		HashMap<Integer, HashSet<Integer>> trusted = new HashMap<>();

		for (int[] trus : trust) {

			int a = trus[0], b = trus[1];

			trusting.computeIfAbsent(a, v -> new HashSet<>()).add(b);
			trusted.computeIfAbsent(b, v -> new HashSet<>()).add(a);
		}

		for (int i = 1; i <= n; i++) {
			if (!trusting.containsKey(i) && trusted.containsKey(i) && trusted.get(i).size() == n - 1)
				return i;
		}
		return -1;
	}
}