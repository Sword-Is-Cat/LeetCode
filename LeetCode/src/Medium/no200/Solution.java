package Medium.no200;

class Solution {

	int answer = 0;

	public int numIslands(char[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == '1') {
					answer++;
					dfs(i, j, grid);
				}
				;
			}
		}
		return answer;
	}

	void dfs(int i, int j, char[][] grid) {
		if (i < 0 || j < 0 ||
				i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
			return;
		else {
			grid[i][j] = '0';
			dfs(i - 1, j, grid);
			dfs(i + 1, j, grid);
			dfs(i, j - 1, grid);
			dfs(i, j + 1, grid);
		}

	}
}