package Medium.no739;

import java.util.PriorityQueue;

class Solution_ {
	public int[] dailyTemperatures(int[] temperatures) {

		int[] ans = new int[temperatures.length];
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

		for (int idx = 0; idx < ans.length; idx++) {

			while (!queue.isEmpty() && queue.peek()[0] < temperatures[idx]) {

				int i = queue.poll()[1];
				ans[i] = idx - i;
			}
			queue.add(new int[] { temperatures[idx], idx });
		}
		return ans;
	}
}