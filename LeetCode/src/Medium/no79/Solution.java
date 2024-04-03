package Medium.no79;

class Solution {

	// directions (up, down, left, right)
	int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {

		boolean[][] visit = new boolean[board.length][board[0].length];
		char[] wordArr = word.toCharArray();

		boolean answer = false;

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length && !answer; col++) {
				answer |= areaSearch(board, visit, wordArr, row, col, 0);
			}
		}

		return answer;
	}

	private boolean areaSearch(char[][] board, boolean[][] visit, char[] word, int row, int col, int idx) {

		// all character matched
		if (idx == word.length)
			return true;

		// check coord(row, col) valid
		if (row < 0 || board.length <= row || col < 0 || board[row].length <= col || visit[row][col])
			return false;

		// check character match & unvisit
		if (board[row][col] != word[idx] || visit[row][col])
			return false;

		boolean result = false;
		visit[row][col] = true;

		// check next step (4 directions)
		for (int i = 0; i < dir.length && !result; i++) {
			result |= areaSearch(board, visit, word, row + dir[i][0], col + dir[i][1], idx + 1);
		}

		visit[row][col] = false;
		return result;
	}

}