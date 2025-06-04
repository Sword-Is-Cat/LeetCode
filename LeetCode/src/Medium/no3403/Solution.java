package Medium.no3403;

import java.util.ArrayDeque;

class Solution {
	public String answerString(String word, int numFriends) {

		if (numFriends == 1)
			return word;

		int wordLength = word.length() - numFriends + 1;

		ArrayDeque<Integer> prev, curr = new ArrayDeque<>();
		for (int i = 0; i < word.length(); i++)
			curr.offer(i);
		char temp = 'a';

		for (int length = 0; length < wordLength && curr.size() > 1; length++) {
			temp = 'a';
			prev = curr;
			curr = new ArrayDeque<>();
			while (!prev.isEmpty()) {
				int idx = prev.pop();
				if (idx + length < word.length()) {
					char ch = word.charAt(idx + length);
					if (temp < ch) {
						temp = ch;
						curr.clear();
					}
					if (temp == ch)
						curr.offer(idx);
				}
			}
		}

		int idx = curr.pop();
		return word.substring(idx, Math.min(word.length(), idx + wordLength));
	}
}