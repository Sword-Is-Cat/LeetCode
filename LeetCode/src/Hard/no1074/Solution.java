package Hard.no1074;

class Solution {

	int[][] sums;

	public int numSubmatrixSumTarget(int[][] matrix, int target) {

		int rLength = matrix.length, cLength = matrix[0].length;
		sums = new int[rLength][cLength];

		for (int row = 0; row < rLength; row++) {
			int rowSum = 0;
			for (int col = 0; col < cLength; col++) {
				rowSum += matrix[row][col];
				sums[row][col] = getValue(row - 1, col) + rowSum;
			}
		}

		int ans = 0;

		for (int row1 = 0; row1 < rLength; row1++) {
			for (int col1 = 0; col1 < cLength; col1++) {
				for (int row2 = row1; row2 < rLength; row2++) {
					for (int col2 = col1; col2 < cLength; col2++) {
						if (getSumOfSubmatrices(row1, col1, row2, col2) == target)
							ans++;
					}
				}
			}
		}

		return ans;

	}

	private int getSumOfSubmatrices(int row1, int col1, int row2, int col2) {
		return getValue(row2, col2) - getValue(row2, col1 - 1) - getValue(row1 - 1, col2)
				+ getValue(row1 - 1, col1 - 1);
	}

	private int getValue(int row, int col) {
		if (row < 0 || col < 0)
			return 0;
		return sums[row][col];
	}
}