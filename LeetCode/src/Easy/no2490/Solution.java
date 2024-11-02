package Easy.no2490;

class Solution {
	public boolean isCircularSentence(String sentence) {

		char prev = sentence.charAt(sentence.length() - 1);
		boolean answer = true;

		for (String word : sentence.split(" ")) {
			answer &= word.charAt(0) == prev;
			prev = word.charAt(word.length() - 1);
		}
		return answer;
	}
}