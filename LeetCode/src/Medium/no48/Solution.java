package Medium.no48;

class Solution {
	public void rotate(int[][] matrix) {

		int length = matrix.length;
		int[] temp;

		for (int i = 0; i * 2 < length; i++) {
			temp = matrix[i];
			matrix[i] = matrix[length - 1 - i];
			matrix[length - 1 - i] = temp;
		}

		int no;

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				no = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = no;
			}
		}

	}
}