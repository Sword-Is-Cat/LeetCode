package Medium.no918;

import java.util.PriorityQueue;

class Solution {
	public int maxSubarraySumCircular(int[] nums) {

		int length = nums.length;
		int[] sums = new int[length * 2];

		for (int i = 0; i < sums.length; i++) {
			if (i > 0)
				sums[i] = sums[i - 1];
			sums[i] += nums[i % length];
		}

		PriorityQueue<int[]> que = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		int ans = sums[0], sum = 0, start = -1;

		for (int end = 0; end < sums.length; end++) {

			int[] arr = null;

			if (length <= end) {

				while (!que.isEmpty() && (que.peek()[0] < sum || end - start > length)) {
					arr = que.poll();
					sum = arr[0];
					start = arr[1];
				}

				ans = Math.max(ans, sums[end] - sum);
			}

			que.add(new int[] { sums[end], end });
		}
		return ans;
	}
}