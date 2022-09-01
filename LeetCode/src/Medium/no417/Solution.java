package Medium.no417;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public List<List<Integer>> pacificAtlantic(int[][] heights) {

		int row = heights.length, col = heights[0].length;
		boolean[][] pacific = new boolean[row][col], atlantic = new boolean[row][col];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {

				if (r == 0 || c == 0)
					findOrigin(heights, pacific, r, c, -1);

				if (r == row - 1 || c == col - 1)
					findOrigin(heights, atlantic, r, c, -1);

			}
		}

		List<List<Integer>> list = new ArrayList<>();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {

				if (pacific[r][c] && atlantic[r][c]) {
					List<Integer> temp = new ArrayList<>();
					temp.add(r);
					temp.add(c);
					list.add(temp);
				}

			}
		}

		return list;

	}

	void findOrigin(int[][] heights, boolean[][] sea, int row, int col, int prev) {

		if (row < 0 || row >= heights.length)
			return;
		if (col < 0 || col >= heights[row].length)
			return;
		if (sea[row][col])
			return;
		if (heights[row][col] < prev)
			return;

		sea[row][col] = true;
		int val = heights[row][col];

		findOrigin(heights, sea, row + 1, col, val);
		findOrigin(heights, sea, row - 1, col, val);
		findOrigin(heights, sea, row, col + 1, val);
		findOrigin(heights, sea, row, col - 1, val);

	}

}