package Medium.no200;

class Solution {

	int answer = 0;

	public int numIslands(char[][] grid) {

		boolean[][] visit = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visit[i][j]) {
					answer++;
					visitIsland(i, j, grid, visit);
				}
			}
		}

		return answer;
	}

	void visitIsland(int i, int j, char[][] grid, boolean[][] visit) {

		try {
			if (grid[i][j] == '1' && !visit[i][j]) {
				visit[i][j] = true;
				visitIsland(i - 1, j, grid, visit);
				visitIsland(i + 1, j, grid, visit);
				visitIsland(i, j - 1, grid, visit);
				visitIsland(i, j + 1, grid, visit);
			}
		} catch (Exception e) {
			return;
		}
	}
}