package Hard.no2014;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public String longestSubsequenceRepeatedK(String s, int k) {

		char[] origin = s.toCharArray();
		int[] freq = new int[26];
		for (char ch : origin)
			freq[ch - 'a']++;

		List<Character> chars = new ArrayList<>();
		for (int i = 25; i >= 0; i--) {
			if (freq[i] >= k)
				chars.add((char) (i + 'a'));
		}

		Queue<String> queue = new ArrayDeque<>();
		for (char ch : chars)
			queue.offer(String.valueOf(ch));

		String ans = "";

		while (!queue.isEmpty()) {
			String curr = queue.poll();
			if (ans.length() < curr.length())
				ans = curr;
			for (char ch : chars) {
				String next = curr + ch;
				if (isRepeat(origin, next, k))
					queue.offer(next);
			}
		}

		return ans;

	}

	private boolean isRepeat(char[] origin, String part, int k) {
		for (int i = 0, j = 0; i < origin.length; i++) {
			if (origin[i] == part.charAt(j)) {
				j++;
				if (j == part.length()) {
					j = 0;
					k--;
					if (k == 0)
						return true;
				}
			}
		}
		return false;
	}
}