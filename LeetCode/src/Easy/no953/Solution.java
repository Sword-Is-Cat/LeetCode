package Easy.no953;

class Solution {

	int[] rule = new int[26];

	public boolean isAlienSorted(String[] words, String order) {

		for (int i = 0; i < 26; i++) {
			rule[order.charAt(i) - 'a'] = i;
		}

		for (int i = 1; i < words.length; i++) {
			if (compareCustom(words[i - 1], words[i]) > 0)
				return false;
		}

		return true;
	}

	protected int compareCustom(String str1, String str2) {

		int length1 = str1.length(), length2 = str2.length();

		for (int i = 0; i < Math.min(length1, length2); i++) {
			char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
			if (ch1 != ch2)
				return rule[ch1 - 'a'] - rule[ch2 - 'a'];
		}

		return length1 - length2;
	}
}