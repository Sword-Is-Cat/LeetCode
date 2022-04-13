package Medium.no59;

class Solution {

	final int[][] DIRECTION = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int[][] generateMatrix(int n) {

		int[][] grid = new int[n][n];

		int row = 0;
		int col = -1;
		int value = 1;
		int di = 0;

		while (value <= n * n) {

			row += DIRECTION[di][0];
			col += DIRECTION[di][1];
			grid[row][col] = value++;

			int nextRow = row + DIRECTION[di][0];
			int nextCol = col + DIRECTION[di][1];

			if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == n || grid[nextRow][nextCol] != 0) {
				di = (di + 1) % 4;
			}
		}
		return grid;
	}
}