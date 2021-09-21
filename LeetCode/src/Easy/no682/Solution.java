package Easy.no682;

import java.util.Stack;

class Solution {
	public int calPoints(String[] ops) {

		Stack<Integer> stack = new Stack<>();

		for (String op : ops) {

			if (op.equals("C")) {
				stack.pop();
			} else if (op.equals("D")) {
				stack.add(stack.peek() * 2);
			} else if (op.equals("+")) {
				int temp = stack.pop();
				int score = stack.peek() + temp;
				stack.add(temp);
				stack.add(score);
			} else {
				stack.add(Integer.parseInt(op));
			}

		}

		int sum = 0;
		while (!stack.isEmpty())
			sum += stack.pop();

		return sum;

	}
}