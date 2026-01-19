package Medium.no1292;

class Solution {
	public int maxSideLength(int[][] mat, int threshold) {

		int[][] sum = new int[mat.length + 1][mat[0].length + 1];
		for (int r = 1; r < sum.length; r++) {
			int temp = 0;
			for (int c = 1; c < sum[r].length; c++) {
				temp += mat[r - 1][c - 1];
				sum[r][c] = sum[r - 1][c] + temp;
			}
		}

		int length = Math.min(mat.length, mat[0].length) + 1;
		while (--length > 0) {
			for (int r = 0; r + length < sum.length; r++) {
				for (int c = 0; c + length < sum[r].length; c++) {
					int area = sum[r + length][c + length] - sum[r + length][c] - sum[r][c + length] + sum[r][c];
					if (area <= threshold)
						return length;
				}
			}
		}

		return 0;
	}
}