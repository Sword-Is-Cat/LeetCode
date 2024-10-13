package Hard.no632;

import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public int[] smallestRange(List<List<Integer>> nums) {

		int[] answer = new int[] { -100000, 100000 };
		int rangeEnd = -100000;

		// queue's item {upperIdx, lowerIdx, value}
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

		int[] item;
		for (int i = 0; i < nums.size(); i++) {
			item = new int[] { i, 0, nums.get(i).get(0) };
			queue.offer(item);
			rangeEnd = Math.max(rangeEnd, item[2]);
		}

		while (true) {

			item = queue.poll();

			if (rangeEnd - item[2] < answer[1] - answer[0]) {
				answer[0] = item[2];
				answer[1] = rangeEnd;
			}

			item[1]++;
			if (item[1] < nums.get(item[0]).size()) {
				item[2] = nums.get(item[0]).get(item[1]);
				rangeEnd = Math.max(rangeEnd, item[2]);
				queue.offer(item);
			} else {
				return answer;
			}
		}
	}
}