package Medium.no861;

class Solution {
	public int matrixScore(int[][] grid) {

		int rowMax = grid.length, colMax = grid[0].length;
		for (int row = 0; row < rowMax; row++) {
			if (grid[row][0] == 0) {
				toggleRow(grid, row);
			}
		}

		for (int col = 0; col < colMax; col++) {
			int flag = 0;
			for (int row = 0; row < rowMax; row++) {
				if (grid[row][col] == 1)
					flag++;
				else
					flag--;
			}
			if (flag < 0) {
				toggleCol(grid, col);
			}
		}

		int ans = 0;
		for (int row = 0; row < rowMax; row++) {
			ans += binaryToDemical(grid[row]);
		}
		return ans;
	}

	private int binaryToDemical(int[] binary) {
		int result = 0;
		for (int digit : binary) {
			result <<= 1;
			result += digit;
		}
		return result;
	}

	private void toggleRow(int[][] grid, int row) {
		for (int col = 0; col < grid[row].length; col++) {
			grid[row][col] ^= 1;
		}
	}

	private void toggleCol(int[][] grid, int col) {
		for (int row = 0; row < grid.length; row++) {
			grid[row][col] ^= 1;
		}
	}
}