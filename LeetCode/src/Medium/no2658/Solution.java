package Medium.no2658;

class Solution {

	int[] dir = { 0, 1, 0, -1, 0 };

	public int findMaxFish(int[][] grid) {

		boolean[][] visit = new boolean[grid.length][grid[0].length];
		int ans = 0;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				ans = Math.max(ans, areaSearch(r, c, grid, visit));
			}
		}

		return ans;

	}

	private int areaSearch(int r, int c, int[][] grid, boolean[][] visit) {
		if (-1 == r || r == grid.length || -1 == c || c == grid[r].length)
			return 0;
		if (grid[r][c] == 0 || visit[r][c])
			return 0;
		int rst = grid[r][c];
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			rst += areaSearch(r + dir[d], c + dir[d + 1], grid, visit);
		}
		return rst;
	}
}