package Hard.no2577;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	int[] dir = { 0, 1, 0, -1, 0 };

	public int minimumTime(int[][] grid) {

		if (grid[0][1] > 1 && grid[1][0] > 1)
			return -1;

		int row = grid.length, col = grid[0].length;
		int[][] times = new int[row][col];

		for (int i = 0; i < row; i++) {
			Arrays.fill(times[i], 1000000);
		}

		Queue<int[]> dijkQue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		dijkQue.offer(new int[] { 0, 0, 0 });

		while (!dijkQue.isEmpty()) {

			int[] item = dijkQue.poll();
			int r = item[0], c = item[1], t = item[2];
			int newTime = Math.max(t, grid[r][c]);
			if (newTime % 2 != t % 2)
				newTime++;
			if (times[r][c] > newTime) {
				times[r][c] = newTime;
				for (int d = 0; d + 1 < dir.length; d++) {
					int nr = r + dir[d], nc = c + dir[d + 1];
					if (-1 < nr && -1 < nc && nr < row && nc < col) {
						dijkQue.offer(new int[] { nr, nc, newTime + 1 });
					}
				}
			}

		}

		return times[row - 1][col - 1];
	}
}