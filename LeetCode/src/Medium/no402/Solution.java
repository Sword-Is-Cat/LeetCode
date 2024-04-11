package Medium.no402;

import java.util.ArrayDeque;

class Solution {
	public String removeKdigits(String num, int k) {

		ArrayDeque<Character> queue = new ArrayDeque<>();
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);

			while (!queue.isEmpty() && queue.peekLast() > ch && k > 0) {
				queue.pollLast();
				k--;
			}

			queue.add(ch);

		}

		while (k-- > 0 && !queue.isEmpty())
			queue.pollLast();

		while (!queue.isEmpty() && queue.peek() == '0')
			queue.poll();

		if (queue.isEmpty())
			queue.add('0');

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.poll());
		}

		return sb.toString();
	}
}