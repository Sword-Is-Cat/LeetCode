package Medium.no966;

import java.util.HashMap;
import java.util.HashSet;

class Solution {

	HashSet<String> originWords = new HashSet<>();
	HashMap<String, String> lowerCaseWords = new HashMap<>();
	HashMap<String, String> devoLowerWords = new HashMap<>();

	public String[] spellchecker(String[] wordlist, String[] queries) {

		for (String word : wordlist) {
			originWords.add(word);
			lowerCaseWords.putIfAbsent(word.toLowerCase(), word);
			devoLowerWords.putIfAbsent(devowelWord(word), word);
		}

		String[] answer = new String[queries.length];

		for (int i = 0; i < queries.length; i++) {
			answer[i] = procQuery(queries[i]);
		}

		return answer;
	}

	public String procQuery(String query) {
		if (originWords.contains(query))
			return query;
		String lower = query.toLowerCase();
		if (lowerCaseWords.containsKey(lower))
			return lowerCaseWords.get(lower);
		String devo = devowelWord(query);
		if (devoLowerWords.containsKey(devo))
			return devoLowerWords.get(devo);
		return "";
	}

	public String devowelWord(String word) {
		StringBuilder sb = new StringBuilder();
		for (char ch : word.toLowerCase().toCharArray()) {
			sb.append(isVowel(ch) ? '*' : ch);
		}
		return sb.toString();
	}

	public boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}