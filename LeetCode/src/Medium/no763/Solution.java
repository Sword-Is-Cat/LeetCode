package Medium.no763;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> partitionLabels(String s) {

		List<Integer> answer = new ArrayList<>();
		int[] lastIndex = new int[26];

		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		for (int i = 0, length = 0, target = 0; i < s.length(); i++) {

			length++;
			target = Math.max(target, lastIndex[s.charAt(i) - 'a']);
			if (i == target) {
				answer.add(length);
				length = 0;
			}

		}

		return answer;
	}
}