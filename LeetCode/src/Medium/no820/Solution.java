package Medium.no820;

import java.util.Arrays;

class Solution {
	public int minimumLengthEncoding(String[] words) {

		StringBuilder sb = new StringBuilder();
		Arrays.sort(words, (a, b) -> b.length() - a.length());

		for (String word : words) {
			word += "#";
			if (sb.indexOf(word) == -1)
				sb.append(word);
		}

		return sb.length();
	}
}