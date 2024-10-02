package Easy.no1331;

import java.util.Arrays;

class Solution {
	public int[] arrayRankTransform(int[] arr) {

		if (arr.length == 0)
			return arr;

		int[][] original = new int[arr.length][];
		int[][] sorted = new int[arr.length][];

		for (int i = 0; i < arr.length; i++) {
			original[i] = sorted[i] = new int[] { arr[i], 0 };
		}

		Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
		int prev = sorted[0][0], rank = 1;

		for (int i = 0; i < arr.length; i++) {
			if (prev < sorted[i][0]) {
				prev = sorted[i][0];
				rank++;
			}
			sorted[i][1] = rank;
		}

		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[i] = original[i][1];
		}

		return ans;

	}
}