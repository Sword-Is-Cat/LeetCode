package Medium.no91;

import java.util.HashMap;

class Solution_ {

	HashMap<String, Integer> map = new HashMap<>();

	public int numDecodings(String s) {

		if (map.containsKey(s))
			return map.get(s);

		if (s.length() == 0)
			return 1;

		if (s.charAt(0) == '0')
			return 0;

		if (s.length() == 1)
			return 1;

		int result = numDecodings(s.substring(1));

		if (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) < '7') {
			result += numDecodings(s.substring(2));
		}

		map.put(s, result);

		return result;
	}
}