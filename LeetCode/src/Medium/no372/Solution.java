package Medium.no372;

class Solution {

	final int MOD = 1337;
	int[][] cache = new int[MOD][11];

	public int superPow(int a, int[] b) {

		int rst = 1;
		a %= MOD;

		for (int bb : b) {

			rst = customPow(rst, 10);
			rst *= customPow(a, bb);
			rst %= MOD;

		}

		return rst;
	}

	public int customPow(int a, int b) {

		if (a == 0)
			return 0;

		if (b == 0)
			return 1;

		if (cache[a][b] == 0) {

			cache[a][b] = (a * customPow(a, b - 1)) % MOD;

		}

		return cache[a][b];

	}
}