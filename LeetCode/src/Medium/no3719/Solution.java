package Medium.no3719;

import java.util.HashMap;

class Solution {
	public int longestBalanced(int[] nums) {

		HashMap<Integer, Integer> odd = new HashMap<>(), even = new HashMap<>();

		int maxLength = 0;

		for (int i = 0; i < nums.length; i++) {
			odd.clear();
			even.clear();
			for (int j = i; j < nums.length; j++) {
				int num = nums[j];
				if (num % 2 == 0) {
					even.put(num, even.getOrDefault(num, 0) + 1);
				} else {
					odd.put(num, odd.getOrDefault(num, 0) + 1);
				}
				if (even.size() == odd.size()) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}

		return maxLength;
	}
}