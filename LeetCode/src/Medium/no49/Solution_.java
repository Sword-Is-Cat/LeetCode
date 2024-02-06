package Medium.no49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_ {
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {

			String key = convertStr(str);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(str);

		}

		List<List<String>> list = new ArrayList<>();

		for (String key : map.keySet())
			list.add(map.get(key));

		return list;
	}

	String convertStr(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}