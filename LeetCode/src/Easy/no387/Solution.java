package Easy.no387;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int firstUniqChar(String s) {

		Set<Character> allSet = new HashSet<>();
		Set<Character> duplSet = new HashSet<>();

		char[] arr = s.toCharArray();

		for (char ch : arr) {
			if (!allSet.add(ch))
				duplSet.add(ch);
		}

		int answer = -1;

		for (int i = 0; i < arr.length; i++) {
			if (!duplSet.contains(arr[i])) {
				answer = i;
				break;
			}
		}

		return answer;

	}
}