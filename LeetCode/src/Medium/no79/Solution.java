package Medium.no79;

class Solution {
	public boolean exist(char[][] board, String word) {

		boolean result = false;
		boolean[][] visit = new boolean[board.length][board[0].length];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (!result)
					result |= dfs(board, visit, row, col, word, 0);
			}
		}

		return result;

	}

	boolean dfs(char[][] grid, boolean[][] visit, int row, int col, String word, int idx) {

		if (idx == word.length())
			return true;

		boolean result = false;

		if (0 <= row && row < grid.length && 0 <= col && col < grid[row].length) {
			// valid row & col
			if (!visit[row][col] && grid[row][col] == word.charAt(idx)) {
				// non visited & correct word

				visit[row][col] = true;

				result |= dfs(grid, visit, row - 1, col, word, idx + 1);
				result |= dfs(grid, visit, row + 1, col, word, idx + 1);
				result |= dfs(grid, visit, row, col - 1, word, idx + 1);
				result |= dfs(grid, visit, row, col + 1, word, idx + 1);

				visit[row][col] = false;

			}
		}

		return result;
	}
}