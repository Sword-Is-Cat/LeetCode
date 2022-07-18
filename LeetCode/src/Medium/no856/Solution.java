package Medium.no856;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

	Map<Integer, Parenthese> map = new HashMap<>();

	public int scoreOfParentheses(String s) {

		Stack<Parenthese> stack = new Stack<>();
		char[] chArr = s.toCharArray();

		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] == '(') {
				stack.add(new Parenthese(i));
				map.put(i, stack.peek());
			} else {
				stack.pop().e = i;
			}
		}

		return calc(0, chArr.length - 1);
	}

	int calc(int s, int e) {

		int score = 0;
		Parenthese head = map.get(s);

		if (head.e < e) {
			score = calc(s, head.e) + calc(head.e + 1, e);
		} else if (head.e == e) {
			score = head.s + 1 == head.e ? 1 : 2 * calc(head.s + 1, head.e - 1);
		}
		return score;
	}
}

class Parenthese {

	int s = -1;
	int e = -1;

	Parenthese(int s) {
		this.s = s;
	}

}