package Hard.no2097;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

	public int[][] validArrangement(int[][] pairs) {

		Map<Integer, Deque<int[]>> map = new HashMap<>();
		Map<Integer, Integer> count = new HashMap<>();

		for (int[] pair : pairs) {
			count.put(pair[0], count.getOrDefault(pair[0], 0) + 1);
			count.put(pair[1], count.getOrDefault(pair[1], 0) - 1);
			if (!map.containsKey(pair[0]))
				map.put(pair[0], new ArrayDeque<>());
			map.get(pair[0]).offer(pair);
		}

		int init = pairs[0][0];
		for (int key : count.keySet()) {
			if (count.get(key) == 1)
				init = key;
		}

		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(map.get(init).poll());
		int idx = pairs.length - 1;
		while (queue.size() <= idx) {
			int tail = queue.isEmpty() ? init : queue.peekLast()[1];
			if (!map.containsKey(tail) || map.get(tail).isEmpty()) {
				pairs[idx--] = queue.pollLast();
			} else {
				queue.offer(map.get(tail).poll());
			}
		}

		while (!queue.isEmpty()) {
			pairs[idx--] = queue.pollLast();
		}

		return pairs;
	}

}