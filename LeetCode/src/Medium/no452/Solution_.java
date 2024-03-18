package Medium.no452;

import java.util.Arrays;

class Solution_ {
	public int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

		int shoot = points[0][1], arrow = 1;

		for (int[] balloon : points) {

			if (shoot < balloon[0]) {
				shoot = balloon[1];
				arrow++;
			} else {
				shoot = Math.min(shoot, balloon[1]);
			}
		}
		return arrow;
	}
}