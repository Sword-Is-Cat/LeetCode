package Medium.no2530;

import java.util.PriorityQueue;

class Solution {
	public long maxKelements(int[] nums, int k) {

		long ans = 0L;
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int num : nums) {
			queue.offer(num);
		}

		while (k-- > 0) {
			int next = queue.poll();
			ans += next;
			queue.offer((next + 2) / 3);
		}

		return ans;
	}
}