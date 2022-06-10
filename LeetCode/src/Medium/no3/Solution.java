package Medium.no3;

import java.util.HashSet;

class Solution {
	public int lengthOfLongestSubstring(String s) {

		int length = 0;
		int from = 0, to = 0;
		HashSet<Character> set = new HashSet<>();

		while (to < s.length()) {

			if (set.contains(s.charAt(to)))
				set.remove(s.charAt(from++));
			else {
				set.add(s.charAt(to++));
				length = Math.max(length, set.size());
			}
		}

		return length;
	}
}