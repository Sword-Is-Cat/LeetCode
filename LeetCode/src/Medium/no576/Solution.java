package Medium.no576;

class Solution {

	final int MOD = 1000000007;

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

		long[][][] timeLine = new long[maxMove + 1][m][n];
		timeLine[0][startRow][startColumn] = 1;

		long ans = 0;

		for (int i = 1; i < timeLine.length; i++) {
			ans += process(timeLine[i - 1], timeLine[i]);
			ans %= MOD;
		}

		return (int) ans;
	}

	long process(long[][] prev, long[][] next) {

		long rst = 0;

		for (int row = 0; row < prev.length; row++) {
			rst += prev[row][0] + prev[row][prev[0].length - 1];
		}

		for (int col = 0; col < prev[0].length; col++) {
			rst += prev[0][col] + prev[prev.length - 1][col];
		}

		for (int row = 0; row < prev.length; row++) {
			for (int col = 0; col < prev[row].length; col++) {
				next[row][col] = value(prev, row + 1, col) + value(prev, row - 1, col) + value(prev, row, col + 1)
						+ value(prev, row, col - 1);
				next[row][col] %= MOD;
			}
		}

		return rst;
	}

	long value(long[][] arr, int row, int col) {
		if (0 <= row && 0 <= col && row < arr.length && col < arr[row].length)
			return arr[row][col];
		else
			return 0;
	}
}