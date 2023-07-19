package Medium.no435;

import java.util.Arrays;

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int cnt = 0, last = Integer.MIN_VALUE;

		for (int[] interval : intervals) {
			if (interval[0] < last) {
				cnt++;
				last = Math.min(last, interval[1]);
			} else {
				last = interval[1];
			}
		}

		return cnt;
	}
}