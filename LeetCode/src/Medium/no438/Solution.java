package Medium.no438;

import java.util.ArrayList;
import java.util.List;

class Solution {

	int[] cnt = new int[26];

	public List<Integer> findAnagrams(String s, String p) {

		for (char ch : p.toCharArray())
			cnt[ch - 'a']++;

		int pLength = p.length(), sLength = s.length();
		int[] counter = new int[26];
		List<Integer> ans = new ArrayList<>();
		char[] arr = s.toCharArray();

		for (int index = sLength - 1; index >= 0; index--) {

			counter[arr[index] - 'a']++;

			if (index + pLength < sLength)
				counter[arr[index + pLength] - 'a']--;

			if (query(counter))
				ans.add(index);
		}
		return ans;
	}

	protected boolean query(int[] arr) {
		boolean rst = true;
		for (int i = 0; rst && i < 26; i++) {
			rst &= cnt[i] == arr[i];
		}
		return rst;
	}
}