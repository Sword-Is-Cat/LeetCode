package Medium.no128;

import java.util.HashMap;

class Solution {

	HashMap<Integer, Integer> nextMap = new HashMap<>();

	public int longestConsecutive(int[] nums) {

		for (int num : nums)
			input(num);

		int max = 0;

		for (int num : nums)
			max = Math.max(max, output(num) - num);

		return max;
	}

	void input(int num) {
		if (!nextMap.containsKey(num)) {
			nextMap.put(num, output(num + 1));
		}
	}

	int output(int num) {

		if (nextMap.containsKey(num)) {

			nextMap.put(num, output(nextMap.get(num)));
			return nextMap.get(num);

		} else
			return num;
	}
}