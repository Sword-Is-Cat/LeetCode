package Medium.no2870;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
	public int minOperations(int[] nums) {

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int num : nums)
			counter.put(num, counter.getOrDefault(num, 0) + 1);

		int ans = 0;

		for (Entry<Integer, Integer> entry : counter.entrySet()) {
			int value = entry.getValue();
			if (value == 1)
				return -1;
			ans += (value - 1) / 3 + 1;
		}

		return ans;
	}
}