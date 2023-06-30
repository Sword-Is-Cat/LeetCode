package Hard.no1970;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int latestDayToCross(int row, int col, int[][] cells) {

		int[][] grid = new int[row][col];
		int max = row * col;

		for (int i = 0; i < cells.length; i++) {
			grid[cells[i][0] - 1][cells[i][1] - 1] = i;
		}

		int left = 0, right = max;

		while (left + 1 < right) {

			int mid = (left + right) / 2;
			if (checkTime(grid, mid)) {
				left = mid;
			} else {
				right = mid;
			}

		}
		return left;
	}

	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private boolean checkTime(int[][] grid, int time) {
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		Queue<int[]> que = new ArrayDeque<>();
		for (int j = 0; j < grid[0].length; j++) {
			if (isValid(grid, time, 0, j)) {
				visit[0][j] = true;
				que.add(new int[] { 0, j });
			}
		}

		while (!que.isEmpty()) {
			int[] point = que.poll();
			if (point[0] == grid.length - 1)
				return true;
			for (int d = 0; d < dir.length; d++) {
				int nRow = point[0] + dir[d][0], nCol = point[1] + dir[d][1];
				if (isValid(grid, time, nRow, nCol) && !visit[nRow][nCol]) {
					visit[nRow][nCol] = true;
					que.add(new int[] { nRow, nCol });
				}
			}
		}

		return false;
	}

	private boolean isValid(int[][] grid, int time, int row, int col) {
		return 0 <= row && 0 <= col && row < grid.length && col < grid[row].length && grid[row][col] >= time;
	}
}