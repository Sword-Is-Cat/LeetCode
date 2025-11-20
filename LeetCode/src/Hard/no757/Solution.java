package Hard.no757;

import java.util.Arrays;

class Solution {
	public int intersectionSizeTwo(int[][] intervals) {

		int ans = 0, end[] = { -1, -1 };
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		for (int[] info : intervals) {

			if (end[0] == end[1]) {

				if (info[0] < end[0]) {
					end[0] = end[1] = Math.min(end[0], info[1]);
				} else if (info[0] > end[0]) {
					ans += 2;
					end[0] = end[1] = info[1];
				} else {
					// info[0] == end[0]
					ans += 1;
					end[1] = info[1];
				}
			} else {
				if (info[0] > end[0]) {
					ans += 1;
					end[0] = info[1];
				} else {
					end[0] = Math.min(end[0], info[1]);
				}

				if (info[0] > end[1]) {
					ans += 1;
					end[1] = info[1];
				} else {
					end[1] = Math.min(end[1], info[1]);
				}

				Arrays.sort(end);

			}
		}

		return ans;
	}
}