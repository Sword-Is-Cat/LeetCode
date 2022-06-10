package Medium.no3;

import java.util.HashMap;

class Solution {
	public int lengthOfLongestSubstring(String s) {

		char[] arr = s.toCharArray();
		int length = 0;

		if (arr.length > 0) {

			int from = 0, to = 1;
			HashMap<Character, Integer> counter = new HashMap<>();
			for (char ch : arr)
				counter.put(ch, 0);
			counter.replace(arr[0], 1);

			while (to < arr.length) {

				if (isCountUnique(counter)) {
					length = Math.max(length, to - from);
					counter.replace(arr[to], counter.get(arr[to]) + 1);
					to++;
				} else {
					counter.replace(arr[from], counter.get(arr[from]) - 1);
					from++;
				}
			}
			if (isCountUnique(counter))
				length = Math.max(length, to - from);
		}

		return length;
	}

	boolean isCountUnique(HashMap<Character, Integer> map) {

		for (char key : map.keySet())
			if (map.get(key) > 1)
				return false;
		return true;
	}
}