package Easy.no2053;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public String kthDistinct(String[] arr, int k) {
		Map<String, Integer> counter = new HashMap<>();
		for (String str : arr) {
			counter.put(str, counter.getOrDefault(str, 0) + 1);
		}
		int cnt = 0;
		for (String str : arr) {
			if (counter.get(str) == 1) {
				if (++cnt == k) {
					return str;
				}
			}
		}
		return "";
	}
}