package Medium.no1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
	public List<String> removeSubfolders(String[] folder) {

		Trie root = new Trie();
		List<String> answer = new ArrayList<>();
		Arrays.sort(folder, (a, b) -> Integer.compare(a.length(), b.length()));

		for (String folderPath : folder) {
			if (getTrie(root, folderPath.split("/"), 0))
				answer.add(folderPath);
		}

		return answer;
	}

	private boolean getTrie(Trie trie, String[] path, int idx) {
		if (trie.isEnd) {
			return false;
		} else if (idx == path.length) {
			trie.isEnd = true;
			return true;
		} else {
			String key = path[idx];
			if (!trie.child.containsKey(key))
				trie.child.put(key, new Trie());
			trie = trie.child.get(key);
			return getTrie(trie, path, idx + 1);
		}

	}
}

class Trie {
	boolean isEnd;
	HashMap<String, Trie> child;

	Trie() {
		child = new HashMap<>();
	}
}