package Medium.no1631;

class Solution {

	int[][] grid;

	public int minimumEffortPath(int[][] heights) {

		grid = heights;

		int left = -1, right = 1000000;

		while (left + 1 < right) {
			int mid = (left + right) / 2;

			if (possibleEffort(mid))
				right = mid;
			else
				left = mid;

		}

		return right;
	}

	boolean possibleEffort(int effort) {

		boolean[][] psbArr = new boolean[grid.length][grid[0].length];

		visit(psbArr, 0, 0, effort);

		return psbArr[psbArr.length - 1][psbArr[0].length - 1];
	}

	void visit(boolean[][] psbArr, int row, int col, int effort) {

		psbArr[row][col] = true;
		int height = grid[row][col];

		if (row > 0 && !psbArr[row - 1][col] && effort >= Math.abs(height - grid[row - 1][col]))
			visit(psbArr, row - 1, col, effort);

		if (col > 0 && !psbArr[row][col - 1] && effort >= Math.abs(height - grid[row][col - 1]))
			visit(psbArr, row, col - 1, effort);

		if (row + 1 < grid.length && !psbArr[row + 1][col] && effort >= Math.abs(height - grid[row + 1][col]))
			visit(psbArr, row + 1, col, effort);

		if (col + 1 < grid[0].length && !psbArr[row][col + 1] && effort >= Math.abs(height - grid[row][col + 1]))
			visit(psbArr, row, col + 1, effort);

	}
}