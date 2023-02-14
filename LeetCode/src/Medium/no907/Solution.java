package Medium.no907;

import java.util.Stack;

class Solution {
	public int sumSubarrayMins(int[] arr) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		int mod = 1000000007;
		stack.push(-1);
		for (int i = 0; i < arr.length + 1; i++) {
			int currVal = (i <= arr.length - 1) ? arr[i] : 0;
			while (stack.peek() != -1 && currVal < arr[stack.peek()]) {
				int index = stack.pop();
				int j = stack.peek();
				int left = index - j;
				int right = i - index;
				long add = (left * right * (long) arr[index]) % mod;
				ans += add;
				ans %= mod;
			}
			stack.push(i);
		}
		return ans;
	}
}