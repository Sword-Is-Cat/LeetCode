package Easy.no1624;

import java.util.Arrays;

class Solution {
	public int maxLengthBetweenEqualCharacters(String s) {

		int[] minIdx = new int[26], maxIdx = new int[26];
		Arrays.fill(minIdx, s.length());
		Arrays.fill(maxIdx, -1);

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int idx = ch - 'a';
			minIdx[idx] = Math.min(minIdx[idx], i);
			maxIdx[idx] = Math.max(maxIdx[idx], i);
		}

		int ans = -1;

		for (int i = 0; i < 26; i++) {
			ans = Math.max(ans, maxIdx[i] - minIdx[i] - 1);
		}

		return ans;
	}
}