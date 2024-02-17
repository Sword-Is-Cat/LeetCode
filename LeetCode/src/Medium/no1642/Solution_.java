package Medium.no1642;

import java.util.PriorityQueue;

class Solution_ {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		PriorityQueue<Integer> que = new PriorityQueue<>();
		int useBricks = 0;
		int idx = 0;

		while (useBricks <= bricks && ++idx < heights.length) {

			que.add(heights[idx] - heights[idx - 1]);
			if (que.size() > ladders)
				useBricks += Math.max(0, que.poll());
		}

		return idx - 1;
	}
}