package Medium.no1765;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	int[] dir = { 0, 1, 0, -1, 0 };

	public int[][] highestPeak(int[][] isWater) {

		boolean[][] visit = new boolean[isWater.length][isWater[0].length];
		Queue<int[]> queue = new LinkedList<>();

		for (int r = 0; r < isWater.length; r++) {
			for (int c = 0; c < isWater[r].length; c++) {
				if (isWater[r][c] == 1) {
					visit[r][c] = true;
					queue.offer(new int[] { r, c });
				}
			}
		}

		int height = 0;
		while (!queue.isEmpty()) {

			int loop = queue.size();
			while (loop-- > 0) {
				int[] coord = queue.poll();
				int r = coord[0], c = coord[1];
				isWater[r][c] = height;
				for (int d = 0; d < 4; d++) {
					int nr = r + dir[d], nc = c + dir[d + 1];
					if (isCoordValid(nr, nc, isWater) && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.offer(new int[] { nr, nc });
					}
				}
			}

			height++;
		}

		return isWater;
	}

	private boolean isCoordValid(int r, int c, int[][] arr) {
		return r >= 0 && c >= 0 && r < arr.length && c < arr[r].length;
	}
}