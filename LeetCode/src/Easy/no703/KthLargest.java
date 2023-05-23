package Easy.no703;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

	private int limit;
	private Queue<Integer> que;

	public KthLargest(int k, int[] nums) {

		limit = k;
		que = new PriorityQueue<>();

		for (int num : nums)
			que.add(num);

		while (que.size() > limit)
			que.poll();

	}

	public int add(int val) {

		que.add(val);
		while (que.size() > limit)
			que.poll();

		return que.peek();
	}
}