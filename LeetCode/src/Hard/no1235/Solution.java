package Hard.no1235;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int[][] units = new int[startTime.length][];
		for (int idx = 0; idx < startTime.length; idx++) {
			units[idx] = new int[] { startTime[idx], endTime[idx], profit[idx], 0 };
		}

		Arrays.sort(units, (a, b) -> a[0] - b[0]);

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int time = 0, maxProfit = 0;

		for (int i = 0; i < units.length; i++) {

			int[] unit = units[i];
			time = unit[0];

			while (!que.isEmpty() && que.peek()[1] <= time) {
				maxProfit = Math.max(maxProfit, que.poll()[3]);
			}

			unit[3] += unit[2] + maxProfit;
			que.add(unit);
			//System.out.println("add unit [" + unit[0] + "," + unit[1] + "," + unit[2] + "," + unit[3] + "]");

		}

		while (!que.isEmpty()) {
			maxProfit = Math.max(maxProfit, que.poll()[3]);
		}

		return maxProfit;
	}
}