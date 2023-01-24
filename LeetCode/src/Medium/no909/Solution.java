package Medium.no909;

class Solution {

	int length, ans, max;
	int[] linear;

	public int snakesAndLadders(int[][] board) {

		length = board.length;
		max = length * length;
		ans = max;
		linear = new int[max + 1];

		int row = length - 1, col = 0, cell = 1, step = 1;

		while (0 <= row && 0 <= col && col < length) {

			linear[cell++] = board[row][col];

			col += step;

			if (col < 0 || col == length) {
				row--;
				step *= -1;
				col += step;
			}
		}

		dfs(1, 0);

		return ans == max ? -1 : ans;
	}

	protected void dfs(int index, int move) {

		if (index == max || ans < move) {
			ans = Math.min(ans, move);
			return;
		}

		boolean justMove = true;

		for (int step = 6; step > 0; step--) {

			int next = Math.min(index + step, max);

			if (linear[next] == -1 && justMove) {
				justMove = false;
				dfs(next, move + 1);
			}

			if (linear[next] != -1 && linear[next] != 1) {
				dfs(linear[next], move + 1);
			}
		}
	}
}