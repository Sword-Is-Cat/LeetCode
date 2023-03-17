package Medium.no208;

class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		getLeafNode(word, true).isEnd = true;
	}

	public boolean search(String word) {
		TrieNode node = getLeafNode(word, false);
		return node != null && node.isEnd;
	}

	public boolean startsWith(String prefix) {
		TrieNode node = getLeafNode(prefix, false);
		return node != null;
	}

	private TrieNode getLeafNode(String str, boolean createIfAbsent) {
		TrieNode node = root;
		for (int i = 0; i < str.length() && node != null; i++) {
			node = node.getChildNode(str.charAt(i), createIfAbsent);
		}
		return node;
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