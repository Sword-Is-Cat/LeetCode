package Medium.no1813;

class Solution {
	public boolean areSentencesSimilar(String sentence1, String sentence2) {

		boolean answer = false;

		answer |= isPrefix(sentence1, sentence2);
		answer |= isSuffix(sentence1, sentence2);
		answer |= isPrefix(sentence2, sentence1);
		answer |= isSuffix(sentence2, sentence1);

		for (int i = 0; !answer && i < sentence1.length(); i++) {
			if (sentence1.charAt(i) == ' ') {
				answer |= isPrefix(sentence1.substring(0, i), sentence2)
						&& isSuffix(sentence1.substring(i + 1), sentence2);
			}
		}
		for (int i = 0; !answer && i < sentence2.length(); i++) {
			if (sentence2.charAt(i) == ' ') {
				answer |= isPrefix(sentence2.substring(0, i), sentence1)
						&& isSuffix(sentence2.substring(i + 1), sentence1);
			}
		}

		return answer;

	}

	private boolean isPrefix(String prefix, String string) {
		if (prefix.length() > string.length())
			return false;
		return string.indexOf(prefix) == 0
				&& (prefix.length() == string.length() || string.charAt(prefix.length()) == ' ');
	}

	private boolean isSuffix(String suffix, String string) {
		if (suffix.length() > string.length())
			return false;
		return string.lastIndexOf(suffix) == string.length() - suffix.length()
				&& (suffix.length() == string.length() || string.charAt(string.length() - suffix.length() - 1) == ' ');
	}
}