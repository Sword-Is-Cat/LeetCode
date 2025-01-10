package Medium.no916;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> wordSubsets(String[] words1, String[] words2) {

		List<String> ans = new ArrayList<>();
		int[][] counts1 = new int[words1.length][26];
		int[][] counts2 = new int[words2.length][26];

		for (int i = 0; i < words1.length; i++) {
			for (int j = 0; j < words1[i].length(); j++) {
				counts1[i][words1[i].charAt(j) - 'a']++;
			}
		}
		for (int i = 0; i < words2.length; i++) {
			for (int j = 0; j < words2[i].length(); j++) {
				counts2[i][words2[i].charAt(j) - 'a']++;
			}
		}

		int[] test = new int[26];
		for (int[] item : counts2) {
			for (int i = 0; i < 26; i++) {
				test[i] = Math.max(test[i], item[i]);
			}
		}

		for (int i = 0; i < words1.length; i++) {
			boolean isSubset = true;
			for (int j = 0; isSubset && j < 26; j++) {
				isSubset &= counts1[i][j] >= test[j];
			}
			if (isSubset)
				ans.add(words1[i]);
		}

		return ans;
	}
}