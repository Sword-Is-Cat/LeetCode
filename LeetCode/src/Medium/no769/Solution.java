package Medium.no769;

import java.util.Stack;

class Solution {
	public int maxChunksToSorted(int[] arr) {

		Stack<int[]> stack = new Stack<>();

		for (int num : arr) {
			int[] item = new int[] { num, num };
			while (!stack.isEmpty() && stack.peek()[1] > item[0]) {
				int[] prev = stack.pop();
				item[0] = Math.min(item[0], prev[0]);
				item[1] = Math.max(item[1], prev[1]);
			}
			stack.push(item);
		}

		return stack.size();
	}
}