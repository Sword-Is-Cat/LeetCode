package Medium.no946;

import java.util.Stack;

class Solution {
	public boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();

		int i = 0, j = 0;
		boolean repeat = true;
		boolean result = false;

		while (repeat) {

			if (i < pushed.length) {

				if (stack.isEmpty() || stack.peek() != popped[j]) {
					stack.add(pushed[i++]);
				} else {
					stack.pop();
					j++;
				}

			} else {

				if (j == popped.length) {
					repeat = false;
					result = true;
				}else if(stack.pop() != popped[j++]) {
					repeat = false;
				}

			}

		}

		return result;
	}
}