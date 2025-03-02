package Easy.no2570;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

		for (int[] num : nums1)
			queue.offer(num);

		for (int[] num : nums2)
			queue.offer(num);

		ArrayList<int[]> list = new ArrayList<>();

		int[] prev = { 0 };
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (prev[0] == curr[0]) {
				prev[1] += curr[1];
			} else {
				prev = curr;
				list.add(curr);
			}
		}

		return list.toArray(new int[0][]);

	}
}