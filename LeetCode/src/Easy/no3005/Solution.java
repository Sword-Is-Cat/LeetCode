package Easy.no3005;

import java.util.HashMap;

class Solution {
	public int maxFrequencyElements(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0, cnt = 0;

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			int c = map.get(num);
			if (c > max) {
				max = c;
				cnt = 1;
			} else if (c == max) {
				cnt++;
			}
		}

		return max * cnt;
	}
}