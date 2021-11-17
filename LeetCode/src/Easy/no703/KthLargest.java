package Easy.no703;

import java.util.PriorityQueue;

class KthLargest {

	int size;
	PriorityQueue<Integer> que;

	public KthLargest(int k, int[] nums) {

		size = k;
		que = new PriorityQueue<>();
		for (int num : nums)
			add(num);
	}

	public int add(int val) {

		if (que.size() < size) {
			que.add(val);
		} else {
			if (que.peek() < val) {
				que.add(val);
				que.poll();
			}
		}
		return que.peek();
	}
}
