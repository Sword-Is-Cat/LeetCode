package Easy.no20;

import java.util.Stack;

class Solution {

	final char[][] pairs = { { '(', ')' }, { '[', ']' }, { '{', '}' } };

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.add(ch);
			} else {

				boolean isPopped = false;
				for (int i = 0; i < 3; i++) {
					char[] pair = pairs[i];
					if (stack.peek() == pair[0] && ch == pair[1]) {
						stack.pop();
						isPopped = true;
						break;
					}
				}
				if (!isPopped) stack.add(ch);
			}
		}

		return stack.isEmpty();
	}
}