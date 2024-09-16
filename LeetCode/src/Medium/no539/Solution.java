package Medium.no539;

import java.util.List;

class Solution {
	public int findMinDifference(List<String> timePoints) {

		boolean[] occur = new boolean[1440];

		int min = 1440, ans = 1440, prev = -1;

		for (String timePoint : timePoints) {
			int time = hhmmToInt(timePoint);
			if (occur[time])
				return 0;
			occur[time] = true;
			min = Math.min(min, time);
		}

		min += 1440;

		for (int t = 0; t < occur.length; t++) {
			if (occur[t]) {
				ans = Math.min(ans, min - t);
				if (prev != -1) {
					ans = Math.min(ans, t - prev);
				}
				prev = t;
			}
		}

		return ans;
	}

	private int hhmmToInt(String hhmm) {
		String[] arr = hhmm.split(":");
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}

}