package Medium.no1593;

class Solution {

	Trie root;

	public int maxUniqueSplit(String s) {

		root = new Trie();

		return dfs(root, s.toCharArray(), 0, 0);

	}

	private int dfs(Trie parent, char[] arr, int idx, int count) {

		if (idx == arr.length)
			return count;

		Trie child = parent.getChild(arr[idx]);

		int result = dfs(child, arr, idx + 1, count);
		if (!child.isAdded) {
			child.isAdded = true;
			result = Math.max(result, dfs(root, arr, idx + 1, count + 1));
			child.isAdded = false;
		}

		return result;
	}
}

class Trie {
	boolean isAdded;
	Trie[] child;

	Trie() {
		isAdded = false;
		child = new Trie[26];
	}

	Trie getChild(char ch) {
		return getChild(ch - 'a');
	}

	Trie getChild(int value) {
		if (child[value] == null)
			child[value] = new Trie();
		return child[value];
	}
}