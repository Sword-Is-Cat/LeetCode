package Medium.no2542;

import java.util.PriorityQueue;

class Solution {
	public long maxScore(int[] nums1, int[] nums2, int k) {

		long max = 0, sum = 0;
		PriorityQueue<int[]> dataPool = new PriorityQueue<>((a, b) -> b[1] - a[1]),
				entry = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int i = 0; i < nums1.length; i++) {
			dataPool.add(new int[] { nums1[i], nums2[i] });
		}

		while (!dataPool.isEmpty()) {

			int[] data = dataPool.poll();
			entry.add(data);
			sum += data[0];

			if (entry.size() > k) {
				sum -= entry.poll()[0];
			}

			if (entry.size() == k) {
				max = Math.max(max, sum * data[1]);
			}

		}

		return max;

	}
}