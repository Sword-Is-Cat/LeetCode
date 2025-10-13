package Easy.no2273;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> removeAnagrams(String[] words) {

		List<String> ans = new ArrayList<>();
		String prev = "";

		for (String word : words) {
			if (!isAnagram(prev, word)) {
				prev = word;
				ans.add(word);
			}
		}

		return ans;
	}

	public boolean isAnagram(String str1, String str2) {

		int[] cnts = new int[26];
		for (char ch : str1.toCharArray()) {
			cnts[ch - 'a']++;
		}
		for (char ch : str2.toCharArray()) {
			cnts[ch - 'a']--;
		}
		for (int cnt : cnts) {
			if (cnt != 0)
				return false;
		}

		return true;
	}

}