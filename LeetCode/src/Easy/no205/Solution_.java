package Easy.no205;

import java.util.HashMap;
import java.util.Map;

class Solution_ {
	public boolean isIsomorphic(String s, String t) {

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();

		boolean result = sArr.length == tArr.length;

		if (result) {

			for (int i = 0; i < sArr.length; i++) {

				if (!sMap.containsKey(sArr[i])) {
					sMap.put(sArr[i], i);
				}
				if (!tMap.containsKey(tArr[i])) {
					tMap.put(tArr[i], i);
				}

			}

			for (int i = 0; i < sArr.length; i++) {
				if (sMap.get(sArr[i]) != tMap.get(tArr[i])) {
					return false;
				}
			}

		}

		return result;
	}
}