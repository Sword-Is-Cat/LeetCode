package Easy.no804;

import java.util.HashSet;

class Solution {

	static final String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };

	public int uniqueMorseRepresentations(String[] words) {

		HashSet<String> set = new HashSet<>();

		for (String word : words)
			set.add(parseStringToMorse(word));

		return set.size();
	}

	public String parseStringToMorse(String str) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++)
			sb.append(MORSE[(int) (str.charAt(i) - 'a')]);

		return sb.toString();
	}

}