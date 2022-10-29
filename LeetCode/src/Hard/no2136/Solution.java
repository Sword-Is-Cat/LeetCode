package Hard.no2136;

import java.util.PriorityQueue;

class Solution {
	public int earliestFullBloom(int[] plantTime, int[] growTime) {

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

		for (int i = 0; i < plantTime.length; i++)
			que.add(new int[] { plantTime[i], growTime[i] });

		int day = 0, finDate = 0;

		while (!que.isEmpty()) {

			int[] seed = que.poll();

			finDate = Math.max(finDate, day + seed[0] + seed[1]);
			day += seed[0];

		}

		return finDate;

	}
}