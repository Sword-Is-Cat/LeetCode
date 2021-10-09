package Medium.no54;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<>();

		int cnt = matrix.length * matrix[0].length;

		while (list.size() < cnt) {

			for(int j = 0 ; j<matrix[0].length ; j++)
				list.add(matrix[0][j]);
			
			matrix = turnArray(matrix);
			
		}

		return list;

	}

	public int[][] turnArray(int[][] array) {

		int[][] result = new int[array[0].length][array.length - 1];

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {

				result[array[0].length - 1 - j][i - 1] = array[i][j];

			}
		}

		return result;

	}
}