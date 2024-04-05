package Easy.no1544;

import java.util.Stack;

class Solution_ {
	public String makeGood(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {

			if (!stack.isEmpty() && isBad(ch, stack.peek())) {
				stack.pop();
			} else {
				stack.add(ch);
			}

		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();

	}

	public boolean isBad(char ch1, char ch2) {
		return ch1 != ch2 && Character.toUpperCase(ch1) == Character.toUpperCase(ch2);
	}
}