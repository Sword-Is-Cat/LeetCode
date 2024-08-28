package Medium.no1905;

class Solution {

	int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		
		int row = grid1.length, col = grid1[0].length;
		int ans = 0;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (grid2[r][c] == 1)
					ans += isSubIslands(grid1, grid2, r, c) ? 1 : 0;
			}
		}

		return ans;
	}

	private boolean isSubIslands(int[][] grid1, int[][] grid2, int row, int col) {

		// invalid coord
		if (row < 0 || col < 0 || row == grid1.length || col == grid1[row].length)
			return true;
		// water, already visited
		if (grid2[row][col] == 0)
			return true;

		grid2[row][col] = 0;
		boolean rst = grid1[row][col] == 1;
		for (int d = 0; d < dir.length; d++)
			rst &= isSubIslands(grid1, grid2, row + dir[d][0], col + dir[d][1]);
		return rst;
	}
}