package Easy.no205;

import java.util.HashMap;

class Solution {
	public boolean isIsomorphic(String s, String t) {

		HashMap<Character, Character> map = new HashMap<>();
		HashMap<Character, Character> revMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ori = s.charAt(i), chng = t.charAt(i);
			map.putIfAbsent(ori, chng);
			revMap.putIfAbsent(chng, ori);
			if (map.get(ori) != chng || revMap.get(chng) != ori)
				return false;
		}

		return true;
	}
}