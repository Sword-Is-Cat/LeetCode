package Medium.no2054;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int maxTwoEvents(int[][] events) {

		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		Queue<int[]> runningQ = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

		int answer = 0, singleEvtVal = 0;

		for (int[] event : events) {

			while (!runningQ.isEmpty() && runningQ.peek()[1] < event[0]) {
				singleEvtVal = Math.max(singleEvtVal, runningQ.poll()[2]);
			}

			answer = Math.max(answer, singleEvtVal + event[2]);
			runningQ.offer(event);

		}

		return answer;
	}
}