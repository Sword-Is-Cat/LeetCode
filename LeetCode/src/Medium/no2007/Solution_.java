package Medium.no2007;

import java.util.PriorityQueue;

class Solution_ {
	public int[] findOriginalArray(int[] changed) {

		int[] ans = new int[changed.length / 2];
		PriorityQueue<Integer> que = new PriorityQueue<>();
		PriorityQueue<Integer> eraseQueue = new PriorityQueue<>();

		for (int num : changed)
			que.add(num);

		int idx = 0;

		while (!que.isEmpty()) {

			int current = que.poll();

			if (!eraseQueue.isEmpty() && current == eraseQueue.peek()) {
				eraseQueue.poll();
			} else {

				if (idx < ans.length) {
					eraseQueue.add(current * 2);
					ans[idx++] = current;
				} else {
					return new int[0];
				}
			}
		}
		return ans;
	}
}