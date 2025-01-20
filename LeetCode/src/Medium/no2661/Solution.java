package Medium.no2661;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int firstCompleteIndex(int[] arr, int[][] mat) {

		Map<Integer, int[]> coordMap = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				coordMap.put(mat[i][j], new int[] { i, j });
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int[] coord = coordMap.get(arr[i]);
			mat[coord[0]][coord[1]] = 0;
			if (checkRow(mat, coord[0]) || checkCol(mat, coord[1]))
				return i;
		}

		return -1;
	}

	private boolean checkRow(int[][] mat, int r) {
		for (int c = 0; c < mat[r].length; c++) {
			if (mat[r][c] > 0)
				return false;
		}
		return true;
	}

	private boolean checkCol(int[][] mat, int c) {
		for (int r = 0; r < mat.length; r++) {
			if (mat[r][c] > 0)
				return false;
		}
		return true;
	}
}