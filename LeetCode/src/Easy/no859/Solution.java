package Easy.no859;

import java.util.Arrays;

class Solution {
	public boolean buddyStrings(String s, String goal) {

		char[] sArr = s.toCharArray();
		char[] gArr = goal.toCharArray();
		int[] cnt = new int[26];

		if (sArr.length != gArr.length)
			return false;

		int[] index = { -1, -1 };
		int idx = 0;

		for (int i = 0; i < sArr.length; i++) {

			cnt[sArr[i] - 'a']++;

			if (sArr[i] != gArr[i]) {
				if (idx == 2)
					return false;
				index[idx++] = i;
			}
		}

		if (idx == 1)
			return false;

		if (idx == 0) {
			return Arrays.stream(cnt).max().getAsInt() > 1;
		}

		return sArr[index[0]] == gArr[index[1]] && sArr[index[1]] == gArr[index[0]];

	}
}