package Medium.no57;

import java.util.ArrayList;

class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		ArrayList<int[]> list = new ArrayList<>();

		for (int[] interval : intervals) {

			if ((interval[1] - newInterval[0]) * (newInterval[1] - interval[0]) >= 0) {
				// 겹치면
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			} else if (interval[0] < newInterval[0]) {
				list.add(interval);
			} else {
				list.add(newInterval);
				newInterval = interval;
			}

		}

		list.add(newInterval);

		// return list.stream().toArray(int[][]::new);

		int[][] answer = new int[list.size()][];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;

	}
}