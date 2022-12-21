package Medium.no886;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public boolean possibleBipartition(int n, int[][] dislikes) {

		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

		for (int[] dislike : dislikes) {
			map.computeIfAbsent(dislike[0], v -> new HashSet<>()).add(dislike[1]);
			map.computeIfAbsent(dislike[1], v -> new HashSet<>()).add(dislike[0]);
		}

		int[] groups = new int[n + 1];
		boolean result = true;

		for (int idx = 1; result && idx <= n; idx++) {
			if (map.containsKey(idx) && groups[idx] == 0) {
				result &= bfs(map, groups, idx, 1);
			}
		}

		return result;
	}

	boolean bfs(HashMap<Integer, HashSet<Integer>> map, int[] groups, int idx, int value) {

		boolean result = true;

		if (groups[idx] == 0) {
			groups[idx] = value;
			for (int key : map.get(idx)) {
				result &= bfs(map, groups, key, -1 * value);
			}
		} else if (groups[idx] * value == -1) {
			result = false;
		}
		return result;
	}
}