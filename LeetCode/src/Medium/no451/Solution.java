package Medium.no451;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public String frequencySort(String s) {
		HashMap<Character, StringBuilder> map = new HashMap<>();
		ArrayList<StringBuilder> list = new ArrayList<>();

		for (char ch : s.toCharArray()) {

			if (!map.containsKey(ch)) {
				StringBuilder sb = new StringBuilder();
				map.put(ch, sb);
				list.add(sb);
			}

			map.get(ch).append(ch);

		}

		StringBuilder ans = new StringBuilder();
		list.sort((a, b) -> b.length() - a.length());

		for (StringBuilder sb : list)
			ans.append(sb);

		return ans.toString();
	}
}