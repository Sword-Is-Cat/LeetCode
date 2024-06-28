package Medium.no2285;

import java.util.Arrays;

class Solution {
	public long maximumImportance(int n, int[][] roads) {

		int[] counts = new int[n];
		for (int[] road : roads) {
			counts[road[0]]++;
			counts[road[1]]++;
		}

		Arrays.sort(counts);
		long ans = 0, value = 1;

		for (int i = 0; i < n; i++) {
			ans += counts[i] * value++;
		}

		return ans;

	}
}