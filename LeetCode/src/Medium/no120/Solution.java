package Medium.no120;

import java.util.List;

class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {

		for (int row = triangle.size() - 2; row >= 0; row--) {
			for (int col = 0; col <= row; col++) {

				triangle.get(row).set(col,

						triangle.get(row).get(col)
								+ Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
}