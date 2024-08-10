package Medium.no959;

class Solution {

	int row, col;
	int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int regionsBySlashes(String[] grid) {

		row = grid.length;
		col = grid[0].length();

		char[][] chGrid = new char[row][];
		for (int r = 0; r < row; r++) {
			chGrid[r] = grid[r].toCharArray();
		}

		int[][][] board = new int[row][col][4];
		int ans = 0;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				for (int s = 0; s < 4; s++) {
					if (board[r][c][s] == 0) {
						bfs(chGrid, board, r, c, s, ++ans);
					}
				}
			}
		}

		return ans;
	}

	private void bfs(char[][] grid, int[][][] board, int r, int c, int s, int color) {

		if (r < 0 || c < 0 || row <= r || col <= c || board[r][c][s] > 0)
			return;

		board[r][c][s] = color;
		switch (grid[r][c]) {
		case '/':
			bfs(grid, board, r, c, s ^ 3, color);
			break;
		case '\\':
			bfs(grid, board, r, c, s ^ 1, color);
			break;
		default:
			bfs(grid, board, r, c, s ^ 1, color);
			bfs(grid, board, r, c, s ^ 2, color);
			bfs(grid, board, r, c, s ^ 3, color);
			break;
		}
		bfs(grid, board, r + dir[s][0], c + dir[s][1], s ^ 2, color);

	}

}