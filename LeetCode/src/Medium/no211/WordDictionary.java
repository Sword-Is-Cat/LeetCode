package Medium.no211;

class WordDictionary {

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		getLeafNode(word, true).isEnd = true;
	}

	private TrieNode getLeafNode(String str, boolean createIfAbsent) {
		TrieNode node = root;
		for (int i = 0; i < str.length() && node != null; i++) {
			node = node.getChildNode(str.charAt(i), createIfAbsent);
		}
		return node;
	}

	public boolean search(String word) {
		return searchDFS(root, word, 0);
	}

	private boolean searchDFS(TrieNode node, String word, int index) {

		if (node == null)
			return false;

		if (index == word.length())
			return node.isEnd;

		char ch = word.charAt(index);

		boolean result = false;

		if (ch == '.') {
			for (int i = 0; i < 26 && !result; i++)
				result |= searchDFS(node.children[i], word, index + 1);
		} else {
			result = searchDFS(node.children[ch - 'a'], word, index + 1);
		}
		return result;
	}
}

class TrieNode {

	boolean isEnd = false;
	TrieNode[] children;

	TrieNode() {
		children = new TrieNode[26];
	}

	TrieNode getChildNode(char ch, boolean createIfAbsent) {
		int idx = ch - 'a';
		if (children[idx] == null && createIfAbsent) {
			children[idx] = new TrieNode();
		}
		return children[idx];
	}
}