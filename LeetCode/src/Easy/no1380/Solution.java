package Easy.no1380;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> luckyNumbers(int[][] matrix) {

		List<Integer> answer = new ArrayList<>();

		int[] rowMins = new int[matrix.length], colmaxs = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == 0) {
					rowMins[i] = matrix[i][j];
				} else {
					rowMins[i] = Math.min(rowMins[i], matrix[i][j]);
				}
				if (i == 0) {
					colmaxs[j] = matrix[i][j];
				} else {
					colmaxs[j] = Math.max(colmaxs[j], matrix[i][j]);
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rowMins[i] == colmaxs[j]) {
					answer.add(matrix[i][j]);
				}
			}
		}

		return answer;
	}
}