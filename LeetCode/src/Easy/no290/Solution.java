package Easy.no290;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean wordPattern(String pattern, String str) {

		Map<Character, String> map = new HashMap<>();
		boolean answer = true;

		char[] charArr = pattern.toCharArray();
		String[] stringArr = str.split(" ");

		if (charArr.length == stringArr.length)
			for (int i = 0; i < charArr.length; i++) {
				if (map.containsKey(charArr[i]) && map.containsValue(stringArr[i])
						&& map.get(charArr[i]).equals(stringArr[i]))
					continue;
				else if (!map.containsKey(charArr[i]) && !map.containsValue(stringArr[i]))
					map.put(charArr[i], stringArr[i]);
				else {
					answer = false;
					break;
				}

			}

		else
			answer = false;

		return answer;

	}
}