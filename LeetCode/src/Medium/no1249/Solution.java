package Medium.no1249;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
	public String minRemoveToMakeValid(String s) {

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '(' || ch == ')') {
				if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
					stack.pop();
					indexStack.pop();
				} else {
					stack.add(ch);
					indexStack.add(i);
				}
			}
		}

		Set<Integer> set = new HashSet<>(indexStack);

		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(i))
				sb.append(arr[i]);
		}
		return sb.toString();
	}
}