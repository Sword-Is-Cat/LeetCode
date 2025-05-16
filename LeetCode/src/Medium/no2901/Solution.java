package Medium.no2901;

import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {

		int length = words.length;
		int[][] info = new int[length][2];
		for (int i = 0; i < length; i++) {
			info[i][0] = -1;
			info[i][1] = 1;
		}

		int maxLength = 1, targetIdx = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (info[i][1] + 1 > info[j][1] && isNext(i, j, words, groups)) {
					info[j][0] = i;
					info[j][1] = info[i][1] + 1;
					if (maxLength < info[j][1]) {
						maxLength = info[j][1];
						targetIdx = j;
					}
				}
			}
		}

		LinkedList<String> list = new LinkedList<>();
		while (targetIdx > -1) {
			list.addFirst(words[targetIdx]);
			targetIdx = info[targetIdx][0];
		}

		return list;
	}

	private boolean isNext(int i, int j, String[] words, int[] groups) {
		if (groups[i] == groups[j])
			return false;
		if (words[i].length() != words[j].length())
			return false;
		int cntDiff = 0;
		for (int idx = 0; idx < words[i].length(); idx++) {
			if (words[i].charAt(idx) != words[j].charAt(idx))
				cntDiff++;
			if (cntDiff > 1)
				return false;
		}
		return cntDiff == 1;
	}
}