package Medium.no3170;

import java.util.Stack;

class Solution {
	public String clearStars(String s) {

		char[] arr = s.toCharArray();

		Stack<Integer>[] stacks = new Stack[26];
		for (int i = 0; i < stacks.length; i++)
			stacks[i] = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '*') {
				for (int j = 0; j < stacks.length; j++) {
					if (!stacks[j].isEmpty()) {
						arr[stacks[j].pop()] = '*';
						break;
					}
				}
			} else {
				stacks[ch - 'a'].push(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : arr)
			if (ch != '*')
				sb.append(ch);

		return sb.toString();
	}
}