package Hard.no2751;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

		int robots = positions.length;
		List<Integer> answer = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		Integer[] indexs = new Integer[robots];

		for (int i = 0; i < robots; i++) {
			indexs[i] = i;
		}

		Arrays.sort(indexs, (a, b) -> Integer.compare(positions[a], positions[b]));

		for (int i = 0; i < robots; i++) {

			int currIdx = indexs[i];
			if (directions.charAt(currIdx) == 'R') {
				stack.push(currIdx);
			} else {
				if (!stack.isEmpty()) {
					int topIdx = stack.pop();
					if (healths[topIdx] == healths[currIdx]) {
						healths[topIdx] = 0;
						healths[currIdx] = 0;
					} else if (healths[topIdx] < healths[currIdx]) {
						healths[topIdx] = 0;
						healths[currIdx]--;
						i--;
					} else {
						healths[topIdx]--;
						healths[currIdx] = 0;
						stack.push(topIdx);
					}
				}
			}

		}

		for (int i = 0; i < robots; i++) {
			int health = healths[i];
			if (health > 0) {
				answer.add(health);
			}
		}

		return answer;

	}
}