package Medium.no3342;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

	int rowMax, colMax;
	int[] dir = { 0, 1, 0, -1, 0 };

	public int minTimeToReach(int[][] moveTime) {

		rowMax = moveTime.length;
		colMax = moveTime[0].length;
		int[][][] reachTime = new int[rowMax][colMax][2];
		for (int i = 0; i < rowMax; i++) {
			for (int j = 0; j < colMax; j++) {
				Arrays.fill(reachTime[i][j], Integer.MAX_VALUE);
			}
		}

		reachTime[0][0][0] = 0;

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> reachTime[a[0]][a[1]][a[2]]));
		queue.offer(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int r = item[0], c = item[1], cost = item[2];
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d], nc = c + dir[d + 1];
				if (isValid(nr, nc)) {
					int newTime = Math.max(reachTime[r][c][cost], moveTime[nr][nc]) + cost + 1;
					if (newTime < reachTime[nr][nc][1 - cost]) {
						reachTime[nr][nc][1 - cost] = newTime;
						queue.offer(new int[] { nr, nc, 1 - cost });
					}
				}
			}
		}

		return Math.min(reachTime[rowMax - 1][colMax - 1][0], reachTime[rowMax - 1][colMax - 1][1]);
	}

	private boolean isValid(int row, int col) {
		return row >= 0 && col >= 0 && row < rowMax && col < colMax;
	}

}