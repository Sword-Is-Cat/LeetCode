package Medium.no648;

import java.util.List;

class Solution {
	public String replaceWords(List<String> dictionary, String sentence) {

		Trie root = new Trie(' ');

		for (String dicWord : dictionary) {
			wordToTrie(root, dicWord, 0);
		}

		StringBuilder sb = null;

		for (String word : sentence.split(" ")) {
			if (sb == null)
				sb = new StringBuilder();
			else
				sb.append(' ');

			sb.append(getRoot(root, word, 0));
		}

		return sb.toString();
	}

	private void wordToTrie(Trie node, String word, int idx) {
		if (word.length() == idx) {
			node.isEnd = true;
			node.word = word;
		} else {
			char ch = word.charAt(idx);
			if (node.children[ch - 'a'] == null) {
				node.children[ch - 'a'] = new Trie(ch);
			}
			wordToTrie(node.children[ch - 'a'], word, idx + 1);
		}
	}

	private String getRoot(Trie node, String word, int idx) {
		if (node.isEnd) {
			return node.word;
		} else if (word.length() == idx || node.children[word.charAt(idx) - 'a'] == null) {
			return word;
		} else {
			return getRoot(node.children[word.charAt(idx) - 'a'], word, idx + 1);
		}
	}
}

class Trie {
	char ch;
	boolean isEnd;
	String word;
	Trie[] children;

	Trie(char ch) {
		this.ch = ch;
		this.isEnd = false;
		this.word = null;
		this.children = new Trie[26];
	}
}