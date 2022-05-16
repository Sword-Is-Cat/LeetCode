package Medium.no57;

import java.util.Arrays;

class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		int[][] result = new int[intervals.length + 1][2];
		for (int i = 0; i < intervals.length; i++) {
			result[i] = intervals[i];
		}
		result[intervals.length] = newInterval;

		Arrays.sort(result, (a, b) -> a[0] - b[0]);

		int rIdx = -1;
		int wIdx = 0;

		while (++rIdx < result.length) {

			int[] rArr = result[rIdx];
			int[] wArr = result[wIdx];

			if ((wArr[1] - rArr[0]) * (rArr[1] - wArr[0]) >= 0) {
				wArr[0] = Math.min(wArr[0], rArr[0]);
				wArr[1] = Math.max(wArr[1], rArr[1]);
			} else {
				result[++wIdx] = rArr;
			}

		}

		return Arrays.copyOfRange(result, 0, ++wIdx);
	}
}