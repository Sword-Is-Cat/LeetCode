package Medium.no539;

import java.util.Arrays;
import java.util.List;

class Solution {
	public int findMinDifference(List<String> timePoints) {

		int[] arr = new int[timePoints.size()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = hhmmToInt(timePoints.get(i));

		Arrays.sort(arr);

		int ans = 1440;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				ans = Math.min(ans, ans + arr[i] - arr[arr.length - 1]);
			} else {
				ans = Math.min(ans, arr[i] - arr[i - 1]);
			}
		}

		return ans;

	}

	private int hhmmToInt(String hhmm) {
		String[] arr = hhmm.split(":");
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}

}