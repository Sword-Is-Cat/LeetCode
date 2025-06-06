package Medium.no2434;

import java.util.Stack;

class Solution {

	public String robotWithString(String s) {

		char[] suffix = new char[s.length()];
		suffix[s.length() - 1] = 'z';
		for (int i = suffix.length - 2; i >= 0; i--) {
			suffix[i] = (char) Math.min(suffix[i + 1], s.charAt(i + 1));
		}

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			stack.push(s.charAt(i));

			while (!stack.isEmpty() && stack.peek() <= suffix[i])
				sb.append(stack.pop());

		}

		return sb.toString();
	}
}