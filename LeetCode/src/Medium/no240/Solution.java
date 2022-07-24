package Medium.no240;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		int row = 0;
		int col = 0;

		while (matrix[row][col] < target && row + 1 < matrix.length)
			row++;

		while (row >= 0 && col < matrix[row].length) {

			if (matrix[row][col] > target)
				row--;
			else if (matrix[row][col] < target)
				col++;
			else
				return true;

		}
		return false;
	}
}