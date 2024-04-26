package Hard.no1289;

class Solution {
	public int minFallingPathSum(int[][] grid) {

		int prevMin = 0, prevSubMin = 0, currMin = 0, currSubMin = 0;

		for (int row = 0; row < grid.length; row++) {

			prevMin = currMin;
			prevSubMin = currSubMin;
			currMin = currSubMin = Integer.MAX_VALUE;

			for (int col = 0; col < grid[row].length; col++) {

				if (row > 0) {
					grid[row][col] += grid[row - 1][col] == prevMin ? prevSubMin : prevMin;
				}
				if (currMin > grid[row][col]) {
					currSubMin = currMin;
					currMin = grid[row][col];
				} else {
					currSubMin = Math.min(currSubMin, grid[row][col]);
				}

			}
		}

		return currMin;

	}
}