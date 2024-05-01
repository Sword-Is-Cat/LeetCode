package Easy.no2000;

class Solution {
	public String reversePrefix(String word, char ch) {

		int idx = word.indexOf(ch) + 1;

		return new StringBuilder().append(word.substring(0, idx)).reverse().append(word.substring(idx)).toString();
	}
}
