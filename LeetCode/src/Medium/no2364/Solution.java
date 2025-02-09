package Medium.no2364;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public long countBadPairs(int[] nums) {

		Map<Integer, Integer> counter = new HashMap<>();
		long ans = 0, total = nums.length;

		for (int i = 0; i < nums.length; i++) {
			int key = nums[i] - i;
			counter.put(key, counter.getOrDefault(key, 0) + 1);
		}

		for (int key : counter.keySet()) {
			int cnt = counter.get(key);
			total -= cnt;
			ans += total * cnt;
		}

		return ans;

	}
}