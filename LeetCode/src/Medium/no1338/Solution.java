package Medium.no1338;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

	public int minSetSize(int[] arr) {

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int num : arr) {

			if (!counter.containsKey(num))
				counter.put(num, 0);

			counter.put(num, counter.get(num) + 1);

		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

		for (int key : counter.keySet())
			queue.add(counter.get(key));

		int target = (arr.length + 1) / 2;
		int removed = 0;
		int ans = 0;

		while (removed < target) {
			ans++;
			removed += queue.poll();
		}

		return ans;
	}
}