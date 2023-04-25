package Medium.no2336;

import java.util.PriorityQueue;

class SmallestInfiniteSet {

	int next;
	PriorityQueue<Integer> que;

	public SmallestInfiniteSet() {
		next = 1;
		que = new PriorityQueue<>();
	}

	public int popSmallest() {
		return que.isEmpty() ? next++ : que.poll();
	}

	public void addBack(int num) {
		if (num < next && !que.contains(num))
			que.add(num);
	}
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet(); int param_1 =
 * obj.popSmallest(); obj.addBack(num);
 */