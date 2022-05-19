package Medium.no63;

class Solution {
	public int uniquePathsWithObstacles(int[][] grid) {

		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
			return 0;

		int[][] ways = new int[grid.length][grid[0].length];
		ways[0][0] = 1;

		for (int sum = 1; sum < grid.length + grid[0].length - 1; sum++) {

			for (int row = 0; row < sum + 1; row++) {

				int col = sum - row;

				if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 0) {

					if (row > 0)
						ways[row][col] += ways[row - 1][col];
					if (col > 0)
						ways[row][col] += ways[row][col - 1];
				}
			}
		}
		return ways[ways.length - 1][ways[0].length - 1];
	}
}