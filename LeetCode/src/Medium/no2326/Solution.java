package Medium.no2326;

import java.util.ArrayDeque;

class Solution {
	public int[][] spiralMatrix(int m, int n, ListNode head) {

		int[][] grid = new int[m][n];

		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 3, move = 0;
		int row = 0, col = -1;
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.add(n + 1);
		que.add(m);

		int loop = m * n;
		while (loop-- > 0) {

			if (move == 0) {
				move = que.poll() - 1;
				d = (d + 1) % 4;
				que.add(move);
			}

			row += dir[d][0];
			col += dir[d][1];
			move--;

			if (head == null) {
				grid[row][col] = -1;
			} else {
				grid[row][col] = head.val;
				head = head.next;
			}

		}

		return grid;
	}
}