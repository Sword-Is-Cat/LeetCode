package Hard.no1255;

class Solution {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
		return getMaxScoreDfs(words, 0, getLetterCounter(letters), score, 0);
	}

	private int getMaxScoreDfs(String[] words, int idx, int[] boundary, int[] score, int currentScore) {
		if (idx == words.length) {
			return currentScore;
		} else {
			int result = getMaxScoreDfs(words, idx + 1, boundary, score, currentScore);

			int[] counter = getLetterCounter(words[idx]);
			if (inBoundary(boundary, counter)) {
				for (int i = 0; i < boundary.length; i++) {
					boundary[i] -= counter[i];
					currentScore += counter[i] * score[i];
				}
				result = Math.max(result, getMaxScoreDfs(words, idx + 1, boundary, score, currentScore));
				for (int i = 0; i < boundary.length; i++) {
					boundary[i] += counter[i];
				}
			}
			return result;
		}
	}

	private boolean inBoundary(int[] boundary, int[] counter) {
		boolean result = true;
		for (int i = 0; result && i < boundary.length; i++) {
			result &= boundary[i] >= counter[i];
		}
		return result;
	}

	private int[] getLetterCounter(String str) {
		return getLetterCounter(str.toCharArray());
	}

	private int[] getLetterCounter(char[] letters) {
		int[] result = new int[26];
		for (char ch : letters) {
			result[ch - 'a']++;
		}
		return result;
	}
}
