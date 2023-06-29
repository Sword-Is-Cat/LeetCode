package Hard.ex864;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	char[][] board;

	public int shortestPathAllKeys(String[] grid) {

		// convert grid to char array
		board = new char[grid.length][];
		for (int i = 0; i < grid.length; i++) {
			board[i] = grid[i].toCharArray();
		}

		// find start point and keys
		int sRow = 0, sCol = 0, allKeys = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				char cell = board[row][col];
				if (cell == '@') {
					sRow = row;
					sCol = col;
				} else if (Character.isLowerCase(cell)) {
					allKeys += 1 << cell - 'a';
				}
			}
		}

		// bfs
		int move = 0, size = 0;
		// state container [row, col, keys]
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { sRow, sCol, 0 });
		boolean[][][] visit = new boolean[board.length][board[0].length][allKeys];
		visit[sRow][sCol][0] = true;

		while (!que.isEmpty()) {
			move++;
			size = que.size();
			while (size-- > 0) {
				int[] state = que.poll();
				for (int d = 0; d < dir.length; d++) {
					int nRow = state[0] + dir[d][0], nCol = state[1] + dir[d][1], key = state[2];
					if (isValid(nRow, nCol)) {
						char nCell = board[nRow][nCol];
						if (Character.isLowerCase(nCell)) {
							if (((key >> nCell - 'a') & 1) == 0)
								key += 1 << nCell - 'a';
						} else if (Character.isUpperCase(nCell)) {
							if (((key >> nCell - 'A') & 1) == 0)
								continue;
						}

						if (key == allKeys)
							return move;

						if (!visit[nRow][nCol][key]) {
							visit[nRow][nCol][key] = true;
							que.add(new int[] { nRow, nCol, key });
						}
					}
				}
			}
		}

		return -1;
	}

	private boolean isValid(int row, int col) {
		return 0 <= row && 0 <= col && row < board.length && col < board[row].length && board[row][col] != '#';
	}

}