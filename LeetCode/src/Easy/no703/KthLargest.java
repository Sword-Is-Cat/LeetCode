package Easy.no703;

import java.util.PriorityQueue;

class KthLargest {

	PriorityQueue<Integer> que;
	int k;

	public KthLargest(int k, int[] nums) {

		que = new PriorityQueue<>();
		this.k = k;

		for (int num : nums)
			que.add(num);

	}

	public int add(int val) {
		que.add(val);
		while (que.size() > k)
			que.poll();
		return que.peek();
	}
}