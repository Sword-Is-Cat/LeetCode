package Medium.no3341;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

	int rowMax, colMax;
	int[] dir = { 0, 1, 0, -1, 0 };

	public int minTimeToReach(int[][] moveTime) {

		rowMax = moveTime.length;
		colMax = moveTime[0].length;
		int[][] reachTime = new int[rowMax][];
		for (int i = 0; i < rowMax; i++) {
			reachTime[i] = new int[colMax];
			Arrays.fill(reachTime[i], Integer.MAX_VALUE);
		}

		reachTime[0][0] = 0;

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
		queue.offer(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int r = item[0], c = item[1], t = item[2];
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d], nc = c + dir[d + 1];
				if (isValid(nr, nc)) {
					int newTime = Math.max(t + 1, moveTime[nr][nc] + 1);
					if (newTime < reachTime[nr][nc]) {
						reachTime[nr][nc] = newTime;
						queue.offer(new int[] { nr, nc, newTime });
					}
				}
			}
		}

		return reachTime[rowMax - 1][colMax - 1];
	}

	private boolean isValid(int row, int col) {
		return row >= 0 && col >= 0 && row < rowMax && col < colMax;
	}

}