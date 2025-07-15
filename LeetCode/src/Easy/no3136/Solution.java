package Easy.no3136;

class Solution {
	public boolean isValid(String word) {

		if (word.length() < 3)
			return false;

		boolean hasVowel = false, hasConsonant = false;
		for (char ch : word.toCharArray()) {
			if (!isValid(ch))
				return false;
			else if (isVowel(ch))
				hasVowel = true;
			else if (!isDigit(ch))
				hasConsonant = true;
		}

		return hasVowel && hasConsonant;
	}

	private boolean isValid(char ch) {
		return ('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
	}

	private boolean isDigit(char ch) {
		return '0' <= ch && ch <= '9';
	}

	private boolean isVowel(char ch) {
		char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (char v : vowel) {
			if (v == ch)
				return true;
		}
		return false;
	}

}