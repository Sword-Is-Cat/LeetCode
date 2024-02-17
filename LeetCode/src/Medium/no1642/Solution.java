package Medium.no1642;

import java.util.PriorityQueue;

class Solution {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (int i = 1; i < heights.length; i++) {
			if (heights[i] > heights[i - 1]) {

				que.add(heights[i] - heights[i - 1]);
				if (que.size() > ladders)
					bricks -= que.poll();

				if (bricks < 0)
					return i - 1;

			}
		}

		return heights.length - 1;
	}
}
