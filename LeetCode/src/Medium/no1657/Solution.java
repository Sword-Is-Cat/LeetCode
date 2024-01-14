package Medium.no1657;

import java.util.Arrays;

class Solution {

	public boolean closeStrings(String word1, String word2) {

		if (word1.length() != word2.length())
			return false;

		int[] cnt1 = countSpells(word1), cnt2 = countSpells(word2);

		boolean flag = true;

		for (int i = 0; flag && i < 26; i++) {
			flag &= (cnt1[i] == 0 && cnt2[i] == 0) || (cnt1[i] != 0 && cnt2[i] != 0);
		}
		
		if (flag) {
			Arrays.sort(cnt1);
			Arrays.sort(cnt2);

			for (int i = 0; flag && i < 26; i++)
				flag &= cnt1[i] == cnt2[i];
		}

		return flag;

	}

	private int[] countSpells(String str) {
		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		return count;
	}
}