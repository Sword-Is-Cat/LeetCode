package Medium.no1020;

class Solution {

	int rMax, cMax;
	int[][] grid;

	public int numEnclaves(int[][] grid) {

		rMax = grid.length;
		cMax = grid[0].length;
		this.grid = grid;

		for (int row = 0; row < rMax; row++) {
			removeBorder(row, 0);
			removeBorder(row, cMax - 1);
		}

		for (int col = 0; col < cMax; col++) {
			removeBorder(0, col);
			removeBorder(rMax - 1, col);
		}

		int ans = 0;

		for (int row = 0; row < rMax; row++) {
			for (int col = 0; col < cMax; col++) {
				ans += grid[row][col];
			}
		}

		return ans;
	}

	private void removeBorder(int row, int col) {

		if (row < 0 || col < 0 || row == rMax || col == cMax || grid[row][col] == 0)
			return;

		grid[row][col] = 0;

		removeBorder(row + 1, col);
		removeBorder(row - 1, col);
		removeBorder(row, col + 1);
		removeBorder(row, col - 1);

	}
}