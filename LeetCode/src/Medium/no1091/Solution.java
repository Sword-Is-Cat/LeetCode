package Medium.no1091;

import java.util.ArrayList;

class Solution {

	final int[][] DIRECTION = { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {

		if (grid[0][0] == 1)
			return -1;

		int dist = 1;
		if (grid.length == 1)
			return dist;

		ArrayList<int[]> set = new ArrayList<>(), newSet;
		set.add(new int[] { 0, 0 });

		while (!set.isEmpty()) {

			dist++;
			newSet = new ArrayList<>();
			for (int[] point : set) {

				for (int[] direct : DIRECTION) {

					int row = point[0] + direct[0];
					int col = point[1] + direct[1];

					if (isValid(row, col, grid)) {

						if (row + 1 == grid.length && col + 1 == grid.length)
							return dist;

						grid[row][col] = 1;
						newSet.add(new int[] { row, col });
					}
				}
			}
			set = newSet;
		}

		return -1;
	}

	boolean isValid(int row, int col, int[][] grid) {

		return row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 0;
	}
}