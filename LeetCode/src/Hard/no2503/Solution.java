package Hard.no2503;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
	public int[] maxPoints(int[][] grid, int[] queries) {

		int[] qPoints = queries.clone();
		Arrays.sort(qPoints);
		Map<Integer, Integer> qPointsToResult = new HashMap<>();

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		queue.offer(new int[] { 0, 0 });
		visit[0][0] = true;

		int count = 0;
		int[] dir = { 0, 1, 0, -1, 0 };

		for (int i = 0; i < qPoints.length; i++) {

			int qPoint = qPoints[i];

			while (!queue.isEmpty() && qPoint > getValue(queue.peek(), grid)) {
				int[] coord = queue.poll();
				count++;
				for (int d = 0; d < 4; d++) {
					int nr = coord[0] + dir[d], nc = coord[1] + dir[d + 1];
					if (isCoordValid(nr, nc, grid) && !visit[nr][nc]) {
						queue.offer(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}

			qPointsToResult.put(qPoint, count);

		}

		for (int i = 0; i < queries.length; i++) {
			queries[i] = qPointsToResult.get(queries[i]);
		}

		return queries;
	}

	private int getValue(int[] coord, int[][] grid) {
		return grid[coord[0]][coord[1]];
	}

	private boolean isCoordValid(int row, int col, int[][] grid) {
		return row >= 0 && col >= 00 && row < grid.length && col < grid[row].length;
	}
}