package Hard.no2290;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

	int[] dir = { 0, 1, 0, -1, 0 };

	public int minimumObstacles(int[][] grid) {

		int row = grid.length, col = grid[0].length;
		Queue<int[]> curr, next = new ArrayDeque<>();
		boolean[][] visit = new boolean[row][col];

		next.offer(new int[] { 0, 0 });
		visit[0][0] = true;

		int move = 0;
		while (move < row * col) {

			curr = next;
			next = new ArrayDeque<>();

			while (!curr.isEmpty()) {

				int[] coord = curr.poll();
				int r = coord[0], c = coord[1];
				if (r == row - 1 && c == col - 1)
					return move;

				for (int d = 0; d + 1 < dir.length; d++) {
					int nr = r + dir[d], nc = c + dir[d + 1];
					if (-1 < nr && nr < row && -1 < nc && nc < col && !visit[nr][nc]) {
						visit[nr][nc] = true;
						if (grid[nr][nc] == 0)
							curr.offer(new int[] { nr, nc });
						else
							next.offer(new int[] { nr, nc });
					}
				}

			}

			move++;
		}

		return -1;
	}
}