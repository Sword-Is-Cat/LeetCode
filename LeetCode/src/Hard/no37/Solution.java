package Hard.no37;

class Solution {

	boolean[][] rowCheck, colCheck, areaCheck;
	boolean solved;
	char[][] board;

	public void solveSudoku(char[][] board) {

		this.board = board;
		rowCheck = new boolean[9][10];
		colCheck = new boolean[9][10];
		areaCheck = new boolean[9][10];
		solved = false;
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] != '.')
					placeNum(r, c, board[r][c] - '0');
			}
		}

		process(0, 0);

	}

	private int areaNo(int row, int col) {
		return (row / 3) * 3 + col / 3;
	}

	public boolean possiblePlace(int row, int col, int num) {
		return !(rowCheck[row][num] || colCheck[col][num] || areaCheck[areaNo(row, col)][num]);
	}

	public void placeNum(int row, int col, int num) {
		rowCheck[row][num] ^= true;
		colCheck[col][num] ^= true;
		areaCheck[areaNo(row, col)][num] ^= true;
		board[row][col] = (char) ('0' + num);
	}

	public void removeNum(int row, int col, int num) {
		rowCheck[row][num] ^= true;
		colCheck[col][num] ^= true;
		areaCheck[areaNo(row, col)][num] ^= true;
		board[row][col] = '.';
	}

	public void process(int row, int col) {
		if (board[row][col] == '.') {
			for (int num = 1; num < 10; num++) {
				if (possiblePlace(row, col, num)) {
					placeNum(row, col, num);
					next(row, col);
					if (!solved)
						removeNum(row, col, num);
				}
			}
		} else {
			next(row, col);
		}
	}

	public void next(int row, int col) {
		if (row + 1 == board.length && col + 1 == board[row].length)
			solved = true;
		else if (col + 1 == board[row].length)
			process(row + 1, 0);
		else
			process(row, col + 1);
	}
}