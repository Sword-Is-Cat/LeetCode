package Medium.no2785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public String sortVowels(String s) {

		char[] arr = s.toCharArray();
		List<Integer> indexList = new ArrayList<>();
		List<Character> charList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (isVowel(arr[i])) {
				indexList.add(i);
				charList.add(arr[i]);
			}
		}

		Collections.sort(charList);

		for (int i = 0; i < indexList.size(); i++) {
			arr[indexList.get(i)] = charList.get(i);
		}

		return new String(arr);
	}

	private boolean isVowel(char ch) {
		return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || // 대문자
				ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'; // 소문자
	}
}