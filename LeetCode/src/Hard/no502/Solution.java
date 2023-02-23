package Hard.no502;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

		int length = profits.length;
		int[][] infos = new int[length][];

		for (int i = 0; i < length; i++) {
			infos[i] = new int[] { capital[i], profits[i] };
		}

		Arrays.sort(infos, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

		int idx = 0;

		while (k-- > 0) {

			while (idx < length && infos[idx][0] <= w) {
				que.add(infos[idx++][1]);
			}

			if (!que.isEmpty()) {
				w += que.poll();
			}

		}

		return w;
	}
}