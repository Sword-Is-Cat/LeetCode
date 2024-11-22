package Medium.no1072;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int maxEqualRowsAfterFlips(int[][] matrix) {

		Map<Trie, Integer> map = new HashMap<>();
		int ans = 0;
		Trie root = new Trie();

		for (int[] row : matrix) {
			Trie trie = root;
			int mask = row[0];
			for (int item : row) {
				trie = trie.getChild(item ^ mask);
			}
			map.put(trie, map.getOrDefault(trie, 0) + 1);
			ans = Math.max(ans, map.get(trie));
		}

		return ans;
	}
}

class Trie {
	Trie[] children;

	Trie() {
		children = new Trie[2];
	}

	protected Trie getChild(int idx) {
		if (children[idx] == null)
			children[idx] = new Trie();
		return children[idx];
	}
}