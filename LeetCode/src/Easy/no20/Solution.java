package Easy.no20;

import java.util.Stack;

class Solution {
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();

		for (char ch : arr) {
			if (stack.empty())
				stack.add(ch);
			else
				switch (ch) {
				case ')':
					if (stack.peek() == '(')
						stack.pop();
					else
						stack.add(ch);
					break;
				case '}':
					if (stack.peek() == '{')
						stack.pop();
					else
						stack.add(ch);
					break;
				case ']':
					if (stack.peek() == '[')
						stack.pop();
					else
						stack.add(ch);
					break;
				default:
					stack.add(ch);
				}

		}

		return (stack.size() == 0) ? true : false;

	}
}