package Easy.no1002;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> commonChars(String[] words) {

		List<String> answer = new ArrayList<>();

		int[] cnt = null;

		for (int i = 0; i < words.length; i++) {
			cnt = getMinArray(cnt, stringCounter(words[i]));
		}

		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i]-- > 0) {
				answer.add(String.valueOf((char) ('a' + i)));
			}
		}

		return answer;

	}

	private int[] stringCounter(String str) {
		int[] result = new int[26];
		for (char ch : str.toCharArray()) {
			result[ch - 'a']++;
		}
		return result;
	}

	private int[] getMinArray(int[] arr1, int[] arr2) {
		if (arr1 == null)
			return arr2;
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Math.min(arr1[i], arr2[i]);
		}
		return arr1;
	}
}
