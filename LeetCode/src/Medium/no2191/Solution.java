package Medium.no2191;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

	public int[] sortJumbled(int[] mapping, int[] nums) {

		int[] convert = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			convert[i] = convert(nums[i], mapping);
		}

		System.out.println(Arrays.toString(convert));

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(i);
		}

		list.sort((a, b) -> convert[a] == convert[b] ? Integer.compare(a, b) : Integer.compare(convert[a], convert[b]));
		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			answer[i] = nums[list.get(i)];
		}

		return answer;
	}

	private int convert(int num, int[] mapping) {

		Stack<Integer> stack = new Stack<>();
		int value = 0;

		if (num == 0) {
			return mapping[0];
		}

		while (num > 0) {
			stack.add(num % 10);
			num /= 10;
		}
		while (!stack.isEmpty()) {
			value *= 10;
			value += mapping[stack.pop()];
		}

		return value;
	}

}