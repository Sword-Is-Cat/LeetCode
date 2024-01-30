package Medium.no150;

import java.util.Stack;

class Solution {
	public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			int pop;
			switch (token) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				pop = stack.pop();
				stack.push(stack.pop() - pop);
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				pop = stack.pop();
				stack.push(stack.pop() / pop);
				break;
			default:
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

}