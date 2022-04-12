package Easy.no1260;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {

		List<List<Integer>> result = new ArrayList<>();

		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			List<Integer> list = new ArrayList<>();
			result.add(list);
			for (int j = 0; j < col; j++) {
				int idx = i * col + j - k;
				while (idx < 0)
					idx += row * col;
				list.add(grid[idx / col][idx % col]);
			}
		}

		return result;
	}
}