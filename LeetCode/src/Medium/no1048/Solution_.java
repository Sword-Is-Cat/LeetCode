package Medium.no1048;

import java.util.Arrays;
import java.util.HashMap;

class Solution_ {
	public int longestStrChain(String[] words) {

		HashMap<String, Integer> points = new HashMap<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		int ans = 0;

		for (String word : words) {

			int point = 0;

			for (String pred : getPredecessors(word)) {
				if (points.containsKey(pred))
					point = Math.max(point, points.get(pred));
			}

			point++;

			points.put(word, point);
			ans = Math.max(ans, point);

		}

		return ans;
	}

	public String[] getPredecessors(String str) {

		int length = str.length();
		String[] result = new String[length];

		for (int i = 0; i < length; i++) {

			if (i == 0)
				result[i] = str.substring(1);
			else if (i + 1 == length)
				result[i] = str.substring(0, i);
			else
				result[i] = str.substring(0, i) + str.substring(i + 1);

		}

		return result;
	}

}