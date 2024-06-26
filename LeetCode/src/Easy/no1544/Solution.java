package Easy.no1544;

import java.util.Stack;

class Solution {
	public String makeGood(String s) {

		Stack<Character> stack = new Stack<>();
		int gap = Math.abs('A' - 'a');
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty() || Math.abs(stack.peek() - ch) != gap)
				stack.add(ch);
			else
				stack.pop();
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}
}