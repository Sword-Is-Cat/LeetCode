package Medium.no49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> answer = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {

			String key = getSortedString(str);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
				answer.add(map.get(key));
			}

			map.get(key).add(str);

		}

		return answer;
	}

	private String getSortedString(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}