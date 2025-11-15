package Medium.no2536;

class Solution {
	public int[][] rangeAddQueries(int n, int[][] queries) {
		int[][] result = new int[n][n], acc = new int[n][n + 1];
		for (int[] query : queries) {
			for (int r = query[0]; r <= query[2]; r++) {
				acc[r][query[1]] += 1;
				acc[r][query[3] + 1] -= 1;
			}
		}
		int value = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c <= n; c++) {
				value += acc[r][c];
				if (c < n)
					result[r][c] = value;
			}
		}
		return result;
	}
}