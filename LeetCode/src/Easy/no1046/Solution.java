package Easy.no1046;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int lastStoneWeight(int[] stones) {

		Queue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

		for (int weight : stones)
			que.add(weight);

		while (que.size() > 1) {
			que.add(que.poll() - que.poll());
		}

		return que.poll();

	}
}