package Medium.no583;

class Solution {

	String word1, word2;
	int[][] cache;

	public int minDistance(String word1, String word2) {

		this.word1 = word1;
		this.word2 = word2;
		cache = new int[word1.length()][word2.length()];

		return process(0, 0);
	}

	int process(int idx1, int idx2) {

		if (idx1 == word1.length() || idx2 == word2.length())
			return word1.length() + word2.length() - idx1 - idx2;

		if (cache[idx1][idx2] == 0) {

			if (word1.charAt(idx1) == word2.charAt(idx2))
				cache[idx1][idx2] = process(idx1 + 1, idx2 + 1);
			else
				cache[idx1][idx2] = Math.min(process(idx1 + 1, idx2), process(idx1, idx2 + 1)) + 1;

		}
		return cache[idx1][idx2];
	}
}