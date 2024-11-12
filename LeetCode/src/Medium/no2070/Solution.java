package Medium.no2070;

import java.util.Arrays;

class Solution {
	public int[] maximumBeauty(int[][] items, int[] queries) {

		Arrays.sort(items, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
		for (int i = 1; i < items.length; i++) {
			items[i][1] = Math.max(items[i][1], items[i - 1][1]);
		}

		for (int i = 0; i < queries.length; i++) {
			queries[i] = getQueryValue(items, queries[i]);
		}

		return queries;
	}

	private int getQueryValue(int[][] items, int query) {

		int left = -1, right = items.length;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (items[mid][0] <= query)
				left = mid;
			else
				right = mid;
		}
		int result = left == -1 ? 0 : items[left][1];
		return result;
	}
}