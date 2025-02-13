package Medium.no3066;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int minOperations(int[] nums, int k) {

		Queue<Long> queue = new PriorityQueue<>();
		int action = 0;

		for (int num : nums) {
			queue.offer((long) num);
		}

		while (queue.peek() < k) {
			queue.offer(queue.poll() * 2 + queue.poll());
			action++;
		}

		return action;
	}
}