package Medium.no456;

import java.util.Stack;

class Solution {
	public boolean find132pattern(int[] nums) {

		Stack<Integer> stack = new Stack<>();
		int last = (int) -1e9 - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			int num = nums[i];
			if (num < last)
				return true;
			while (!stack.isEmpty() && stack.peek() < num)
				last = stack.pop();
			stack.add(num);
		}

		return false;

	}
}