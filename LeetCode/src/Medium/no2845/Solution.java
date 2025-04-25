package Medium.no2845;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

		long answer = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int num : nums) {

			if (num % modulo == k)
				count++;

			answer += map.getOrDefault(((count + modulo - k) % modulo), 0);

			int temp = count % modulo;
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}

		return answer;
	}
}