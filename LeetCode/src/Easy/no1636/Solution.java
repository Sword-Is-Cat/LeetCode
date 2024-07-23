package Easy.no1636;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
	public int[] frequencySort(int[] nums) {

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int num : nums) {
			counter.put(num, counter.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> que = new PriorityQueue<>(
				(a, b) -> counter.get(a) == counter.get(b) ? (Integer.compare(b, a))
						: (Integer.compare(counter.get(a), counter.get(b))));

		for (int num : nums) {
			que.add(num);
		}

		int i = 0;
		while (!que.isEmpty()) {
			nums[i++] = que.poll();
		}

		return nums;
	}
}