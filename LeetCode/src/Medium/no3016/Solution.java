package Medium.no3016;

import java.util.Arrays;

class Solution {
	public int minimumPushes(String word) {

		int[] cnt = new int[26];
		for (char ch : word.toCharArray()) {
			cnt[ch - 'a']++;
		}
		Arrays.sort(cnt);
		int ans = 0;
		for (int i = 0; i < cnt.length; i++) {
			ans += cnt[i] * ((33 - i) / 8);
		}
		return ans;
	}
}