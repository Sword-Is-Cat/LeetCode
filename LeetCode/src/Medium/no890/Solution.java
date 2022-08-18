package Medium.no890;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

	public List<String> findAndReplacePattern(String[] words, String pattern) {

		List<String> list = new ArrayList<>();

		for (String word : words) {

			if (isPatternMatch(word, pattern))
				list.add(word);

		}

		return list;
	}

	boolean isPatternMatch(String word, String pattern) {

		HashSet<Character> dupl = new HashSet<>();

		for (int i = 0; i < pattern.length(); i++) {

			char target = word.charAt(i);
			char tobe = Character.toUpperCase(pattern.charAt(i));

			if (Character.isLowerCase(target) && !dupl.contains(tobe)) {
				word = word.replace(target, tobe);
				dupl.add(tobe);
			}

		}

		return word.toLowerCase().equals(pattern);
	}
}