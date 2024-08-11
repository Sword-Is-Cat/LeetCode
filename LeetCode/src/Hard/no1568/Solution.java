package Hard.no1568;

class Solution {
	public int minDays(int[][] grid) {

		if (countIsland(grid) != 1)
			return 0;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					grid[r][c] = 0;
					if (countIsland(grid) != 1)
						return 1;
					grid[r][c] = 1;
				}
			}
		}

		return 2;
	}

	private int countIsland(int[][] grid) {

		boolean[][] visit = new boolean[grid.length][grid[0].length];
		int result = 0;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1 && !visit[r][c]) {
					result++;
					visitArea(grid, visit, r, c);
				}
			}
		}
		return result;
	}

	private void visitArea(int[][] grid, boolean[][] visit, int r, int c) {

		if (0 <= r && 0 <= c && r < grid.length && c < grid[r].length && !visit[r][c] && grid[r][c] == 1) {
			visit[r][c] = true;
			visitArea(grid, visit, r - 1, c);
			visitArea(grid, visit, r + 1, c);
			visitArea(grid, visit, r, c - 1);
			visitArea(grid, visit, r, c + 1);
		}

	}
}