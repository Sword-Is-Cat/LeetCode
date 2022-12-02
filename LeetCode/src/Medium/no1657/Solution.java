package Medium.no1657;

import java.util.Arrays;

class Solution {
	public boolean closeStrings(String word1, String word2) {

		int[] cnt1 = new int[26], cnt2 = new int[26];

		for (char ch : word1.toCharArray()) {
			cnt1[ch - 'a']++;
		}

		for (char ch : word2.toCharArray()) {
			cnt2[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (cnt1[i] != cnt2[i] && cnt1[i] * cnt2[i] == 0) {
				return false;
			}
		}

		Arrays.sort(cnt1);
		Arrays.sort(cnt2);

		for (int i = 0; i < 26; i++) {
			if (cnt1[i] != cnt2[i]) {
				return false;
			}
		}

		return true;
	}
}