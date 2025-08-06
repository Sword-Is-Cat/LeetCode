package Medium.no3479;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

		int length = baskets.length;
		SegNode[] nodes = new SegNode[length];
		Queue<SegNode> queue = new ArrayDeque<>();
		for (int i = 0; i < length; i++) {
			nodes[i] = new SegNode(i, baskets[i]);
			queue.offer(nodes[i]);
		}

		while (queue.size() > 1) {
			int loop = queue.size();
			while (loop > 1) {
				queue.offer(new SegNode(queue.poll(), queue.poll()));
				loop -= 2;
			}
			if (loop == 1)
				queue.offer(queue.poll());
		}

		SegNode root = queue.poll();
		int answer = 0;

		for (int i = 0; i < length; i++) {

			int idx = root.query(fruits[i]);
			if (idx == -1) {
				answer++;
			} else {
				nodes[idx].update(0);
			}

		}

		return answer;
	}
}

class SegNode {
	int ri, li;
	int capacity;
	SegNode parent, left, right;

	SegNode(int index, int capacity) {
		ri = li = index;
		this.capacity = capacity;
	}

	SegNode(SegNode left, SegNode right) {
		this.left = left;
		this.right = right;
		left.parent = this;
		right.parent = this;
		li = left.li;
		ri = right.ri;
		capacity = Math.max(left.capacity, right.capacity);
	}

	void update() {
		update(Math.max(left.capacity, right.capacity));
	}

	void update(int newCapacity) {
		if (capacity == newCapacity)
			return;
		capacity = newCapacity;
		if (parent != null)
			parent.update();
	}

	int query(int target) {
		if (li == ri)
			return target <= capacity ? li : -1;
		if (capacity < target)
			return -1;
		int result = left.query(target);
		if (result == -1)
			result = right.query(target);
		return result;
	}
}