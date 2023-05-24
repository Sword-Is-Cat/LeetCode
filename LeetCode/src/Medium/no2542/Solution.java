package Medium.no2542;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public long maxScore(int[] nums1, int[] nums2, int k) {

		long max = 0, sum = 0;
		int[][] dataPool = new int[nums1.length][];
		PriorityQueue<int[]> entry = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int i = 0; i < nums1.length; i++) {
			dataPool[i] = new int[] { nums1[i], nums2[i] };
		}

		Arrays.sort(dataPool, (a, b) -> b[1] - a[1]);

		for (int[] data : dataPool) {

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