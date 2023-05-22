package Medium.no347;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, int[]> counter = new HashMap<>();

		for (int num : nums) {
			counter.computeIfAbsent(num, v -> new int[] { num, 0 })[1]++;
		}

		int[][] entries = counter.entrySet().stream().map(entry -> entry.getValue()).toArray(int[][]::new);
		Arrays.sort(entries, (a, b) -> b[1] - a[1]);

		int[] ans = new int[k];

		for (int i = 0; i < k; i++) {
			ans[i] = entries[i][0];
		}

		return ans;

	}
}