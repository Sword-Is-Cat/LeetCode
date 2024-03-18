package Medium.no452;

import java.util.Arrays;

class Solution {
	public int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

		int shoot = points[0][1], cnt = 1;

		for (int[] point : points) {
			if (shoot < point[0]) {
				shoot = point[1];
				cnt++;
			} else {
				shoot = Math.min(shoot, point[1]);
			}
		}

		return cnt;

	}
}