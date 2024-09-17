package Easy.no884;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public String[] uncommonFromSentences(String s1, String s2) {

		int length = 0;

		Map<String, Integer> map = new HashMap<>();
		for (String word : s1.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
			if (map.get(word) == 1) {
				length++;
			} else if (map.get(word) == 2) {
				length--;
			}
		}
		for (String word : s2.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
			if (map.get(word) == 1) {
				length++;
			} else if (map.get(word) == 2) {
				length--;
			}
		}

		String[] ans = new String[length];
		int idx = 0;
		for (String word : map.keySet()) {
			if (map.get(word) == 1) {
				ans[idx++] = word;
			}
		}

		return ans;
	}
}