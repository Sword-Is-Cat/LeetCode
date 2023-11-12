package Hard.no815;

import java.util.*;

class Solution {
	public int numBusesToDestination(int[][] routes, int source, int target) {

		int maxStopNo = -1;
		for (int[] route : routes) {
			for (int stop : route) {
				maxStopNo = Math.max(maxStopNo, stop);
			}
		}

		if (maxStopNo < target)
			return -1;

		int[] required = new int[maxStopNo + 1];
		Arrays.fill(required, routes.length + 1);
		required[source] = 0;

		boolean updateExist = true;
		while (updateExist) {

			updateExist = false;

			for (int[] route : routes) {

				int minVal = required[route[0]];
				for (int stop : route) {
					minVal = Math.min(minVal, required[stop]);
				}
				minVal++;
				for (int stop : route) {
					if (required[stop] > minVal) {
						required[stop] = minVal;
						updateExist = true;
					}
				}

			}

		}

		return required[target] > routes.length ? -1 : required[target];
	}
}