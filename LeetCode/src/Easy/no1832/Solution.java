package Easy.no1832;

import java.util.HashSet;

class Solution {
	public boolean checkIfPangram(String sentence) {
		HashSet<Character> set = new HashSet<>();

		for (char ch : sentence.toCharArray())
			set.add(ch);

		return set.size() == 26;
	}
}