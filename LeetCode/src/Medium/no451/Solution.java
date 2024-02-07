package Medium.no451;

import java.util.Arrays;

class Solution {
	public String frequencySort(String s) {

		int[][] counter = new int[62][2];
		for (int i = 0; i < counter.length; i++) {
			counter[i][0] = i;
		}

		for (char ch : s.toCharArray()) {
			counter[charToInt(ch)][1]++;
		}

		Arrays.sort(counter, (a, b) -> b[1] - a[1]);

		StringBuilder sb = new StringBuilder();

		for (int[] entry : counter) {
			while (entry[1]-- > 0) {
				sb.append(intToChar(entry[0]));
			}
		}

		return sb.toString();
	}

	private int charToInt(char ch) {
		if (Character.isLowerCase(ch))
			return ch - 'a' + 10;
		else if (Character.isUpperCase(ch))
			return ch - 'A' + 36;
		else
			return ch - '0';
	}

	private char intToChar(int i) {
		if (i < 10)
			return (char) ('0' + i);
		else if (i < 36)
			return (char) ('a' - 10 + i);
		else
			return (char) ('A' - 36 + i);
	}
}