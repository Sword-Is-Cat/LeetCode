package Hard.no1326;

import java.util.Arrays;

class Solution {
	public int minTaps(int n, int[] ranges) {

		int[][] arr = new int[n + 1][];
		for (int i = 0; i < ranges.length; i++) {
			arr[i] = new int[] { i - ranges[i], i + ranges[i] };
		}

		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

		int cnt = 0;
		int max = 0, idx = 0;

		while (max < n && idx < arr.length) {

			int temp = -1;
			while (idx < arr.length && arr[idx][0] <= max) {
				temp = Math.max(temp, arr[idx++][1]);
			}
			if (temp == -1 || max == temp)
				return -1;

			cnt++;
			max = temp;
		}

		return cnt;
	}
}