package Easy.no1047;

import java.util.Stack;

class Solution {
	public String removeDuplicates(String s) {

		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {

			if (!stack.isEmpty() && stack.peek() == ch)
				stack.pop();
			else
				stack.add(ch);

		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();

	}
}