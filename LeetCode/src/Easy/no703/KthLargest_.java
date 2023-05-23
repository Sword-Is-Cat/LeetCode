package Easy.no703;

import java.util.PriorityQueue;

class KthLargest_ {

	int size;
	PriorityQueue<Integer> que;

	public KthLargest_(int k, int[] nums) {

		size = k;
		que = new PriorityQueue<>();
		for (int num : nums)
			add(num);
	}

	public int add(int val) {

		que.add(val);
		while (que.size() > size)
			que.poll();

		return que.peek();
	}
}
