package Medium.no659;

import java.util.PriorityQueue;

class Solution {
	public boolean isPossible(int[] nums) {

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

		for (int num : nums) {

			while (!que.isEmpty() && que.peek()[1] < num - 1) {
				int[] section = que.poll();
				if (section[1] - section[0] < 2)
					return false;
			}

			if (!que.isEmpty() && que.peek()[1] == num - 1) {
				int[] section = que.poll();
				section[1] = num;
				que.add(section);
			} else {
				que.add(new int[] { num, num });
			}
		}

		while (!que.isEmpty()) {
			int[] section = que.poll();
			if (section[1] - section[0] < 2)
				return false;
		}

		return true;
	}
}