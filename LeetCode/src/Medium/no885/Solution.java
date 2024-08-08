package Medium.no885;

import java.util.Arrays;

class Solution {
	public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

		int[][] ans = new int[rows * cols][2];

		for (int i = 0; i < rows * cols; i++) {
			ans[i][0] = i / cols;
			ans[i][1] = i % cols;
		}

		Arrays.sort(ans, (cor1, cor2) -> Integer.compare(comparor(cor1[0] - rStart, cor1[1] - cStart),
				comparor(cor2[0] - rStart, cor2[1] - cStart)));

		return ans;
	}

	public int comparor(int r, int c) {

		int rst = 0;

		int dist = Math.max(Math.abs(r), Math.abs(c));
		if (dist == 0)
			return 0;
		rst = (2 * dist - 1) * (2 * dist - 1);

		if (r == -dist)
			rst += 7 * dist + c;
		else if (c == -dist)
			rst += 5 * dist - r;
		else if (r == dist)
			rst += 3 * dist - c;
		else
			rst += dist + r;

		return rst;
	}

}