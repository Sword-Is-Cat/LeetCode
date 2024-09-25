package Hard.no2416;

class Solution {
	public int[] sumPrefixScores(String[] words) {

		Trie root = new Trie();
		Trie[] leaves = new Trie[words.length];
		int[] ans = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			Trie trie = root;
			for (char ch : words[i].toCharArray()) {
				if (trie.child[ch - 'a'] == null)
					trie.child[ch - 'a'] = new Trie(trie);
				trie = trie.child[ch - 'a'];
				trie.cnt++;
			}
			leaves[i] = trie;
		}

		for (int i = 0; i < words.length; i++) {
			ans[i] = leaves[i].getScore();
		}

		return ans;
	}
}

class Trie {

	Trie[] child;
	Trie parent;
	int cnt;
	int score;

	Trie() {
		child = new Trie[26];
		parent = null;
		cnt = 0;
	}

	Trie(Trie parent) {
		this();
		this.parent = parent;
	}

	protected int getScore() {
		if (parent == null)
			return 0;
		if (score == 0) {
			score = cnt + parent.getScore();
		}
		return score;
	}

}