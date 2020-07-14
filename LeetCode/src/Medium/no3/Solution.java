package Medium.no3;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int lengthOfLongestSubstring(String s) {

		int answer = 0;
		char[] arr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		if (arr.length != 0) {

			int i = 0;
			int j = 1;
			map.put(arr[0], 1);

			while (true) {
				if (check(map)) {
					answer = (answer < j - i) ? j - i : answer;
					if (j == arr.length)
						break;
					if (map.containsKey(arr[j])) {
						map.replace(arr[j], map.get(arr[j]) + 1);
					} else {
						map.put(arr[j], 1);
					}
					j++;
				} else {
					map.replace(arr[i], map.get(arr[i]) - 1);
					i++;
				}
			}
		}

		return answer;

	}

	public boolean check(Map<Character, Integer> map) {

		boolean flag = true;

		for (Character ch : map.keySet()) {
			if (map.get(ch) > 1)
				flag = false;
		}

		return flag;
	}

	public static void main(String[] args) {

		String s = "pwwkew";

		Solution sol = new Solution();

		System.out.println(sol.lengthOfLongestSubstring(s));

	}
}