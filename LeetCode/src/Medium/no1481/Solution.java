package Medium.no1481;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int num : arr) {
			counter.put(num, counter.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> que = new PriorityQueue<>(counter.values());

		while (!que.isEmpty() && k >= que.peek()) {
			k -= que.poll();
		}

		return que.size();
	}
}