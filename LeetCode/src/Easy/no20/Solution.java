package Easy.no20;

import java.util.Stack;

class Solution {
	public boolean isValid(String s) {

		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char ch : arr) {
			if (!stack.isEmpty() && (ch - stack.peek() + 1) / 2 == 1) {
				stack.pop();
			} else {
				stack.add(ch);
			}
		}
		return stack.isEmpty();
	}
}