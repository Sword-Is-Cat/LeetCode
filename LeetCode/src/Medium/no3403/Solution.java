package Medium.no3403;

class Solution {
	public String answerString(String word, int numFriends) {

		if (numFriends == 1)
			return word;

		int i = 0, j = 1, length = word.length();
		while (j < length) {
			int k = 0;
			while (j + k < length && word.charAt(i + k) == word.charAt(j + k)) {
				k++;
			}
			if (j + k < length && word.charAt(i + k) < word.charAt(j + k)) {
				int t = i;
				i = j;
				j = Math.max(j + 1, t + k + 1);
			} else {
				j = j + k + 1;
			}
		}

		return word.substring(i, Math.min(word.length(), i + length - numFriends + 1));
	}
}