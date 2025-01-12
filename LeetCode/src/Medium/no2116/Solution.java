package Medium.no2116;

import java.util.Stack;

class Solution {
	public boolean canBeValid(String s, String locked) {

		if (s.length() % 2 == 1)
			return false;

		Stack<Integer> unlock = new Stack<>();
		Stack<Integer> opened = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (locked.charAt(i) == '0')
				unlock.push(i);
			else if (s.charAt(i) == '(')
				opened.push(i);
			else if (!opened.isEmpty())
				opened.pop();
			else if (!unlock.isEmpty())
				unlock.pop();
			else
				return false;
		}

		while (!opened.isEmpty() && !unlock.isEmpty() && opened.peek() < unlock.peek()) {
			opened.pop();
			unlock.pop();
		}

		return opened.isEmpty();
	}
}