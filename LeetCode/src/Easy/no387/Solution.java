package Easy.no387;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int firstUniqChar(String s) {

		Set<Character> allSet = new HashSet<>();
		Set<Character> duplSet = new HashSet<>();

		int length = s.length();

		for (int i = 0; i < length; i++) {

			char ch = s.charAt(i);

			if (!allSet.add(ch))
				duplSet.add(ch);

		}

		int answer = -1;

		for (int i = 0; i < length; i++) {
			if (!duplSet.contains(s.charAt(i))) {
				answer = i;
				break;
			}
		}

		return answer;

	}
}