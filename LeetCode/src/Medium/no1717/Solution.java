package Medium.no1717;

import java.util.Stack;

class Solution {
	public int maximumGain(String s, int x, int y) {

		int ans = 0;

		char[] chars = { 'a', 'a' };
		if (x < y) {
			chars[0] = 'b';
		} else {
			chars[1] = 'b';
		}
		int max = Math.max(x, y), min = Math.min(x, y);

		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(ch);
			} else if (stack.peek() == chars[0] && ch == chars[1]) {
				stack.pop();
				ans += max;
			} else {
				stack.push(ch);
			}
		}

		Stack<Character> temp = new Stack<>();
		while (!stack.isEmpty()) {
			if (temp.isEmpty()) {
				temp.push(stack.pop());
			} else if (stack.peek() == chars[1] && temp.peek() == chars[0]) {
				temp.pop();
				stack.pop();
				ans += min;
			} else {
				temp.push(stack.pop());
			}
		}

		return ans;

	}

}
