package Medium.no1834;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int[] getOrder(int[][] tasks) {

		int[][] orders = new int[tasks.length][];
		int[] ans = new int[tasks.length];

		for (int i = 0; i < tasks.length; i++) {
			orders[i] = new int[] { tasks[i][0], tasks[i][1], i };
		}

		Arrays.sort(orders, (a, b) -> Integer.compare(a[0], b[0]));
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

		int time = 0, idx = 0, ansIdx = 0;

		while (ansIdx < ans.length) {

			if (heap.isEmpty() && time < orders[idx][0]) {
				time = orders[idx][0];
			}

			while (idx < orders.length && orders[idx][0] <= time) {
				heap.add(orders[idx++]);
			}

			int[] order = heap.poll();
			time += order[1];
			ans[ansIdx++] = order[2];
		}

		return ans;
	}
}