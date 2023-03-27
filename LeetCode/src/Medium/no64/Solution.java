package Medium.no64;

class Solution {
	public int minPathSum(int[][] grid) {

		int rowLeng = grid.length, colLeng = grid[0].length;

		for (int row = 0; row < rowLeng; row++) {
			for (int col = 0; col < colLeng; col++) {

				if (row == 0 && col == 0)
					continue;
				else if (row == 0)
					grid[row][col] += grid[row][col - 1];
				else if (col == 0)
					grid[row][col] += grid[row - 1][col];
				else
					grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
			}
		}
		return grid[rowLeng - 1][colLeng - 1];
	}
}