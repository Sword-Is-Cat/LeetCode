package Easy.no2418;

import java.util.Arrays;

class Solution {
	public String[] sortPeople(String[] names, int[] heights) {

		int length = names.length;
		Integer[] index = new Integer[length];
		String[] answer = new String[length];

		for (int i = 0; i < index.length; i++) {
			index[i] = i;
		}

		Arrays.sort(index, (a, b) -> Integer.compare(heights[b], heights[a]));

		for (int i = 0; i < length; i++) {
			answer[i] = names[index[i]];
		}

		return answer;
	}
}