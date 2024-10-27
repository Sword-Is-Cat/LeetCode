package Medium.no1277;

class Solution {
	public int countSquares(int[][] matrix) {

		for (int r = 1; r < matrix.length; r++) {
			for (int c = 1; c < matrix[r].length; c++) {
				if (matrix[r][c] == 1) {
					matrix[r][c] = Math.min(Math.min(matrix[r - 1][c], matrix[r][c - 1]), matrix[r - 1][c - 1]) + 1;
				}
			}
		}
		
		int answer = 0;

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				answer += matrix[r][c];
			}
		}

		return answer;
	}
}