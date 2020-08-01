package Easy.no463;

class Solution {
	public int islandPerimeter(int[][] grid) {

		int island = 0;
		int neighbor = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1) {
					island++;
					if (i > 0 && grid[i - 1][j] == 1)
						neighbor++;
					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						neighbor++;
					if (j > 0 && grid[i][j - 1] == 1)
						neighbor++;
					if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
						neighbor++;
				}
			}
		}

		int answer = island * 4 - neighbor;
		return answer;

	}
}