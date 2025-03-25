package Medium.no3394;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public boolean checkValidCuts(int n, int[][] rectangles) {

		Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));

		int lastCoord, cut = 0;
		lastCoord = rectangles[0][2];

		for (int[] rectangle : rectangles) {
			if (rectangle[0] >= lastCoord) {
				cut++;
			}
			lastCoord = Math.max(lastCoord, rectangle[2]);
		}

		if (cut >= 2)
			return true;

		Arrays.sort(rectangles, Comparator.comparingInt(a -> a[1]));

		lastCoord = rectangles[0][3];
		cut = 0;

		for (int[] rectangle : rectangles) {
			if (rectangle[1] >= lastCoord) {
				cut++;
			}
			lastCoord = Math.max(lastCoord, rectangle[3]);
		}

		if (cut >= 2)
			return true;

		return false;

	}
}