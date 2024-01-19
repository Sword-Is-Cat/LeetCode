package Medium.no931;

class Solution_ {

	public int minFallingPathSum(int[][] matrix) {

		int length = matrix.length;

		for (int row = 1; row < length; row++) {
			for (int col = 0; col < length; col++) {

				if (col == 0) {
					matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]);
				} else if (col == length - 1) {
					matrix[row][col] += Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]);
				} else {
					matrix[row][col] += Math.min(matrix[row - 1][col - 1],
							Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]));
				}
			}
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < length; i++) {
			ans = Math.min(ans, matrix[length - 1][i]);
		}

		return ans;
	}
}