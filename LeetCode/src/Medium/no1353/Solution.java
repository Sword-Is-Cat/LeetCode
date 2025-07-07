package Medium.no1353;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	public int maxEvents(int[][] events) {
		
		int length = events.length;
		int maxDay = 0;
		for (int[] event : events) {
			maxDay = Math.max(maxDay, event[1]);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(events, (a, b) -> a[0] - b[0]);
		int ans = 0;
		for (int i = 1, j = 0; i <= maxDay; i++) {
			while (j < length && events[j][0] <= i) {
				pq.offer(events[j][1]);
				j++;
			}
			while (!pq.isEmpty() && pq.peek() < i) {
				pq.poll();
			}
			if (!pq.isEmpty()) {
				pq.poll();
				ans++;
			}
		}

		return ans;
	}
}