package Medium.no289;

class Solution {
	public void gameOfLife(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				int oldNo = board[i][j];
				int cntLive = 0;

				if (i > 0 && j > 0)
					cntLive += board[i - 1][j - 1] % 2;
				if (i > 0)
					cntLive += board[i - 1][j] % 2;
				if (i > 0 && j < board[i].length - 1)
					cntLive += board[i - 1][j + 1] % 2;
				if (j < board[i].length - 1)
					cntLive += board[i][j + 1] % 2;
				if (i < board.length - 1 && j < board[i].length - 1)
					cntLive += board[i + 1][j + 1] % 2;
				if (i < board.length - 1)
					cntLive += board[i + 1][j] % 2;
				if (i < board.length - 1 && j > 0)
					cntLive += board[i + 1][j - 1] % 2;
				if (j > 0)
					cntLive += board[i][j - 1] % 2;

				int newNo = cntLive == 2 ? oldNo : cntLive == 3 ? 1 : 0;

				board[i][j] = newNo * 2 + oldNo;

			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] /= 2;
			}
		}
	}
}