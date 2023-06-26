package Medium.no2462;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

class Solution {
	public long totalCost(int[] costs, int k, int candidates) {

		ArrayDeque<Integer> dqCost = new ArrayDeque<>();
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		long ans = 0L;

		for (int cost : costs) {
			dqCost.addLast(cost);
		}

		while (candidates-- > 0) {
			if (!dqCost.isEmpty())
				que.add(new int[] { dqCost.pollFirst(), 0 });
			if (!dqCost.isEmpty())
				que.add(new int[] { dqCost.pollLast(), 1 });
		}

		while (k-- > 0) {
			int[] entry = que.poll();

			ans += entry[0];

			if (!dqCost.isEmpty()) {
				if (entry[1] == 0) {
					que.add(new int[] { dqCost.pollFirst(), 0 });
				} else if (entry[1] == 1) {
					que.add(new int[] { dqCost.pollLast(), 1 });
				}
			}

		}

		return ans;
	}
}