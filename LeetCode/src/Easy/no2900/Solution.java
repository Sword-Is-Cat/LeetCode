package Easy.no2900;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> getLongestSubsequence(String[] words, int[] groups) {
		List<String> answer = new ArrayList<>();
		int mask = -1;
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] != mask) {
				mask = groups[i];
				answer.add(words[i]);
			}
		}
		return answer;
	}
}