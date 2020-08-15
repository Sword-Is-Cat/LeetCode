package Challenge.August2nd_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
	public int longestPalindrome(String s) {

		char[] arr = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (char ch : arr) {
			if (map.containsKey(ch))
				map.replace(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}

		Set<Character> set = map.keySet();

		int hasOdd = 0;
		int count = 0;

		for (char ch : set) {

			count += map.get(ch) / 2;

			if (hasOdd == 0 && map.get(ch) % 2 == 1) {
				hasOdd = 1;
			}
		}

		return count * 2 + hasOdd;

	}
}