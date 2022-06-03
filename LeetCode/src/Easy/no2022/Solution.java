package Easy.no2022;

import java.util.Arrays;

class Solution {
	public int[][] construct2DArray(int[] original, int m, int n) {

		if (original.length != m * n)
			return new int[0][0];

		int[][] ans = new int[m][];

		for (int row = 0; row < m; row++)
			ans[row] = Arrays.copyOfRange(original, row * n, (row + 1) * n);

		return ans;
	}
}