package Easy.no3264;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int[] getFinalState(int[] nums, int k, int multiplier) {

		Queue<int[]> que = new PriorityQueue<>(
				(a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

		for (int i = 0; i < nums.length; i++)
			que.offer(new int[] { nums[i], i });

		while (k-- > 0) {
			int[] item = que.poll();
			item[0] *= multiplier;
			que.offer(item);
		}

		while (!que.isEmpty()) {
			int[] item = que.poll();
			nums[item[1]] = item[0];
		}

		return nums;
	}
}