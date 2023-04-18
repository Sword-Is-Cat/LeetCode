package Easy.no1768;

class Solution {
	public String mergeAlternately(String word1, String word2) {

		StringBuilder sb = new StringBuilder();

		int length1 = word1.length(), length2 = word2.length();
		int length = Math.max(length1, length2);

		for (int i = 0; i < length; i++) {
			if (i < length1)
				sb.append(word1.charAt(i));
			if (i < length2)
				sb.append(word2.charAt(i));
		}

		return sb.toString();
	}
}