package Medium.no1190;

import java.util.Stack;

class Solution {
	public String reverseParentheses(String s) {

		Stack<StringBuilder> stack = new Stack<>();
		char[] arr = s.toCharArray();
		stack.push(new StringBuilder());

		for (char ch : arr) {

			switch (ch) {
			case '(':
				stack.push(new StringBuilder());
				break;
			case ')':
				StringBuilder temp = stack.pop();
				stack.peek().append(temp.reverse().toString());
				break;
			default:
				stack.peek().append(ch);
				break;
			}

		}

		return stack.peek().toString();

	}
}