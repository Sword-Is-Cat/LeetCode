package Medium.no1291;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> sequentialDigits(int low, int high) {

		List<Integer> answer = new ArrayList<>();

		for (int length = 2; length < 10; length++) {
			for (int head = 1; head < 10; head++) {

				int number = 0;

				for (int position = 0; position < length; position++) {
					if (position + head > 9) {
						number = 0;
						break;
					} else {
						number = number * 10 + position + head;
					}
				}

				if (low <= number && number <= high) {
					answer.add(number);
				}

			}
		}

		return answer;
	}
}