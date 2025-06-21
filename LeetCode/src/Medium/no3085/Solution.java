package Medium.no3085;

import java.util.Arrays;

class Solution {
	public int minimumDeletions(String word, int k) {

		int[] cnts = new int[26];
		for (char ch : word.toCharArray())
			cnts[ch - 'a']++;

		Arrays.sort(cnts);
		int answer = word.length(), deletion = 0;

		for (int i = 0; i < 26; i++) {

			int temp = deletion;
			for (int j = i + 1; j < 26; j++)
				temp += Math.max(0, cnts[j] - cnts[i] - k);

			deletion += cnts[i];
			answer = Math.min(answer, temp);
		}

		return answer;
	}
}