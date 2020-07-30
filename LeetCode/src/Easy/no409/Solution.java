package Easy.no409;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int longestPalindrome(String s) {

		char[] arr = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (char ch : arr) {
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}

		boolean hasOdd = false;
		int answer = 0;

		for (char ch : map.keySet()) {

			answer += map.get(ch) / 2 * 2;

			if (map.get(ch) % 2 == 1)
				hasOdd = true;
		}

		return hasOdd ? answer + 1 : answer;

	}
}