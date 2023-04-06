package Medium.no1254;

class Solution {

	int rowMax, colMax;
	int[][] grid;
	boolean[][] visit;

	public int closedIsland(int[][] grid) {

		rowMax = grid.length;
		colMax = grid[0].length;
		this.grid = grid;
		visit = new boolean[rowMax][colMax];

		int cnt = 0;

		for (int row = 0; row < rowMax; row++) {
			for (int col = 0; col < colMax; col++) {
				if (grid[row][col] == 0 && !visit[row][col]) {
					cnt += areaSearch(row, col);
				}
			}
		}

		return cnt;
	}

	private int areaSearch(int row, int col) {

		if (row < 0 || col < 0 || row == rowMax || col == colMax)
			return 1;

		if (grid[row][col] == 1 || visit[row][col])
			return 1;

		visit[row][col] = true;

		int rst = row == 0 || col == 0 || row + 1 == rowMax || col + 1 == colMax ? 0 : 1;

		rst *= areaSearch(row + 1, col);
		rst *= areaSearch(row - 1, col);
		rst *= areaSearch(row, col + 1);
		rst *= areaSearch(row, col - 1);

		return rst;

	}
}