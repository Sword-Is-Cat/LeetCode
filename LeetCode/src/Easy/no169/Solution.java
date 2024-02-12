package Easy.no169;

import java.util.HashMap;

class Solution {
	public int majorityElement(int[] nums) {

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int num : nums) {
			counter.put(num, counter.getOrDefault(num, 0) + 1);
		}

		int value = nums[0], cnt = 0;

		for (java.util.Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			if (cnt < entry.getValue()) {
				value = entry.getKey();
				cnt = entry.getValue();
			}
		}

		return value;
	}
}