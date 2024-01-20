package Medium.no907;

import java.util.Stack;

class Solution {
	public int sumSubarrayMins(int[] arr) {
		int ans = 0;
		int mod = (int) 1e9 + 7;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < arr.length + 1; i++) {
			int currVal = (i <= arr.length - 1) ? arr[i] : 0;
			while (stack.peek() != -1 && currVal < arr[stack.peek()]) {
				int index = stack.pop();
				int j = stack.peek();
				long left = index - j, right = i - index;
				ans = (ans + (int) ((left * right * arr[index]) % mod)) % mod;
			}
			stack.push(i);
		}
		return ans;
	}
}