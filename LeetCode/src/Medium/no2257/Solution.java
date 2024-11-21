package Medium.no2257;

class Solution {

	public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

		int[][] grid = new int[m][n];

		for (int[] item : walls) {
			grid[item[0]][item[1]] = 1;
		}
		for (int[] item : guards) {
			grid[item[0]][item[1]] = 1;
		}

		int[] dir = { 0, 1, 0, -1, 0 };

		for (int[] guard : guards) {
			for (int d = 0; d + 1 < dir.length; d++) {
				int r = guard[0], c = guard[1];
				int dr = dir[d], dc = dir[d + 1];
				grid[r][c] = 1;
				while (0 <= r + dr && r + dr < m && 0 <= c + dc && c + dc < n && grid[r + dr][c + dc] != 1) {
					r += dr;
					c += dc;
					grid[r][c] = 2;
				}
			}
		}

		int ans = 0;
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 0)
					ans++;
			}
		}

		return ans;
	}

}