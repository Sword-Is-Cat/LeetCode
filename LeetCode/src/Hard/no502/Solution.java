package Hard.no502;

import java.util.PriorityQueue;

class Solution {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

		PriorityQueue<int[]> standBy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> workable = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int i = 0; i < profits.length; i++) {
			if (capital[i] <= w)
				workable.add(new int[] { capital[i], profits[i] });
			else
				standBy.add(new int[] { capital[i], profits[i] });
		}

		while (k-- > 0) {
			while (!standBy.isEmpty() && standBy.peek()[0] <= w) {
				workable.add(standBy.poll());
			}
			if (!workable.isEmpty()) {
				w += workable.poll()[1];
			}
		}

		return w;
	}
}