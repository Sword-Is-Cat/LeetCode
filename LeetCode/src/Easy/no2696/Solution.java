package Easy.no2696;

import java.util.Stack;

class Solution {
	public int minLength(String s) {

		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty())
				stack.add(ch);
			else if (stack.peek() == 'A' && ch == 'B')
				stack.pop();
			else if (stack.peek() == 'C' && ch == 'D')
				stack.pop();
			else
				stack.add(ch);
		}

		return stack.size();
	}
}