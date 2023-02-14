package Medium.no130;

class Solution {
	public void solve(char[][] board) {

		for (int row = 0; row < board.length; row++) {
			areaSearch(board, row, 0);
			areaSearch(board, row, board[row].length - 1);
		}

		for (int col = 0; col < board[0].length; col++) {
			areaSearch(board, 0, col);
			areaSearch(board, board.length - 1, col);
		}

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {

				switch (board[row][col]) {
				case 'O':
					board[row][col] = 'X';
					break;
				case 'Q':
					board[row][col] = 'O';
					break;
				}
			}
		}
	}

	void areaSearch(char[][] board, int row, int col) {

		if (row < 0 || col < 0 || row == board.length || col == board[row].length)
			return;

		if (board[row][col] == 'O') {
			board[row][col] = 'Q';
			areaSearch(board, row + 1, col);
			areaSearch(board, row - 1, col);
			areaSearch(board, row, col + 1);
			areaSearch(board, row, col - 1);
		}

	}
}