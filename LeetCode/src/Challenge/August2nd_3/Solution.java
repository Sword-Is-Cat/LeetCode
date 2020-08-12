package Challenge.August2nd_3;

import java.util.Arrays;

class Solution {
	public int hIndex(int[] citations) {

		int answer = 0;
		
		Arrays.sort(citations);

		for (int i = 1; i <= citations.length; i++) {
			if (citations[citations.length - i] < i) {
				answer = i - 1;
				break;
			} else if (i == citations.length)
				answer = i;
		}

		return answer;

	}
}