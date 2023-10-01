package Easy.no557;

class Solution {
	public String reverseWords(String s) {
		final String blank = " ";
		StringBuilder sb = new StringBuilder();

		for (String word : s.split(blank)) {
			if (sb.length() > 0)
				sb.append(blank);
			sb.append(new StringBuilder(word).reverse());
		}

		return sb.toString();
	}
}