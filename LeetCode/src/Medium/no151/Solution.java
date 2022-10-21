package Medium.no151;

import java.util.Stack;

class Solution {
	public String reverseWords(String s) {

		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		String[] arr = s.split("[ ]+");

		for (String str : arr) {

			if (!str.isEmpty())
				stack.push(str);
		}

		while (!stack.isEmpty()) {

			if (sb.length() > 0)
				sb.append(" ");

			sb.append(stack.pop());

		}

		return sb.toString();

	}
}