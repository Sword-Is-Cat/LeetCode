package Medium.no542;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int[][] updateMatrix(int[][] mat) {

		int row = mat.length, col = mat[0].length;

		Queue<int[]> que = new ArrayDeque<>();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (mat[r][c] == 0)
					que.add(new int[] { r, c, 0 });
				mat[r][c] = -1;
			}
		}

		while (!que.isEmpty()) {
			int[] info = que.poll();
			int r = info[0], c = info[1], d = info[2];
			if (mat[r][c] > -1 && mat[r][c] <= d)
				continue;
			mat[r][c] = d;
			if (0 < r)
				que.add(new int[] { r - 1, c, d + 1 });
			if (0 < c)
				que.add(new int[] { r, c - 1, d + 1 });
			if (r < row - 1)
				que.add(new int[] { r + 1, c, d + 1 });
			if (c < col - 1)
				que.add(new int[] { r, c + 1, d + 1 });
		}

		return mat;
	}
}