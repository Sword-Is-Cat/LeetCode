package Medium.no74;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		int top = 0;
		int bot = matrix.length;

		while (top + 1 < bot) {

			int mid = (top + bot) / 2;

			if (matrix[mid][0] > target) {
				bot = mid;
			} else {
				top = mid;
			}

		}

		int left = 0;
		int right = matrix[top].length;

		while (left + 1 < right) {

			int mid = (left + right) / 2;

			if (matrix[top][mid] > target) {
				right = mid;
			} else {
				left = mid;
			}

		}

		return matrix[top][left] == target;
	}
}