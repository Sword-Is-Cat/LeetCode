package Medium.no304;

class NumMatrix {

	int[][] grid;

	public NumMatrix(int[][] matrix) {
		grid = matrix.clone();

		for (int row = 0; row < grid.length; row++) {
			for (int col = 1; col < grid[row].length; col++) {
				grid[row][col] += grid[row][col - 1];
			}
		}

		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 1; row < grid.length; row++) {
				grid[row][col] += grid[row - 1][col];
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return grid[row2][col2] 
				- (col1 > 0 ? grid[row2][col1 - 1] : 0)
				- (row1 > 0 ? grid[row1 - 1][col2] : 0)
				+ (row1 > 0 && col1 > 0 ? grid[row1 - 1][col1 - 1] : 0);
	}
}