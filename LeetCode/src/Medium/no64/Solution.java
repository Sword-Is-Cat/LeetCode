package Medium.no64;

class Solution {
	
	int[][] pathSum;

	public int minPathSum(int[][] grid) {

		pathSum = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				pathSum[i][j] = findPathSum(i, j, grid);

		return pathSum[pathSum.length - 1][pathSum[0].length - 1];

	}

	int findPathSum(int i, int j, int[][] grid) {

		int result = grid[i][j];

		if (i == 0 && j == 0)
			return result;
		else if (i == 0)
			result += pathSum[i][j - 1];
		else if (j == 0)
			result += pathSum[i - 1][j];
		else
			result += Math.min(pathSum[i - 1][j], pathSum[i][j - 1]);

		return result;
	}
}