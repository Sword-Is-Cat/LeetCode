package Medium.no542;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
	public int[][] updateMatrix(int[][] mat) {

		int row = mat.length, col = mat[0].length;

		int[][] ans = new int[row][col];
		for (int i = 0; i < row; i++) {
			Arrays.fill(ans[i], -1);
		}

		Queue<int[]> que = new ArrayDeque<>();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (mat[r][c] == 0)
					que.add(new int[] { r, c, 0 });
			}
		}

		while (!que.isEmpty()) {
			int[] info = que.poll();
			int r = info[0], c = info[1], d = info[2];
			if (ans[r][c] != -1 && ans[r][c] <= d)
				continue;
			ans[r][c] = d;
			if (0 < r)
				que.add(new int[] { r - 1, c, d + 1 });
			if (0 < c)
				que.add(new int[] { r, c - 1, d + 1 });
			if (r < row - 1)
				que.add(new int[] { r + 1, c, d + 1 });
			if (c < col - 1)
				que.add(new int[] { r, c + 1, d + 1 });
		}

		return ans;
	}
}