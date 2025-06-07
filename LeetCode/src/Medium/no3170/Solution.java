package Medium.no3170;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	public String clearStars(String s) {

		char[] arr = s.toCharArray();

		List<Stack<Integer>> stacks = new ArrayList<>();
		for (int i = 0; i < 26; i++)
			stacks.add(new Stack<>());

		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '*') {
				for (int j = 0; j < 26; j++) {
					if (!stacks.get(j).isEmpty()) {
						arr[stacks.get(j).pop()] = '*';
						break;
					}
				}
			} else {
				stacks.get(ch - 'a').push(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : arr)
			if (ch != '*')
				sb.append(ch);

		return sb.toString();
	}
}