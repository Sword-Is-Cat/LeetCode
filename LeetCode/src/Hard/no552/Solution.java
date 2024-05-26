package Hard.no552;

class Solution {

	final int MOD = (int) 1e9 + 7;

	public int checkRecord(int n) {

		int[][] prev, curr = new int[2][3];
		curr[0][0] = 1;
		curr[0][1] = 1;
		curr[1][0] = 1;

		while (--n > 0) {

			prev = curr;
			curr = new int[2][3];

			// [1] 출석P
			curr[0][0] = (curr[0][0] + prev[0][0]) % MOD;
			curr[0][0] = (curr[0][0] + prev[0][1]) % MOD;
			curr[0][0] = (curr[0][0] + prev[0][2]) % MOD;
			curr[1][0] = (curr[1][0] + prev[1][0]) % MOD;
			curr[1][0] = (curr[1][0] + prev[1][1]) % MOD;
			curr[1][0] = (curr[1][0] + prev[1][2]) % MOD;

			// [2] 지각L
			curr[0][1] = (curr[0][1] + prev[0][0]) % MOD;
			curr[0][2] = (curr[0][2] + prev[0][1]) % MOD;
			curr[1][1] = (curr[1][1] + prev[1][0]) % MOD;
			curr[1][2] = (curr[1][2] + prev[1][1]) % MOD;

			// [3] 결석A
			curr[1][0] = (curr[1][0] + prev[0][0]) % MOD;
			curr[1][0] = (curr[1][0] + prev[0][1]) % MOD;
			curr[1][0] = (curr[1][0] + prev[0][2]) % MOD;
		}

		int ans = 0;
		ans = (ans + curr[0][0]) % MOD;
		ans = (ans + curr[0][1]) % MOD;
		ans = (ans + curr[0][2]) % MOD;
		ans = (ans + curr[1][0]) % MOD;
		ans = (ans + curr[1][1]) % MOD;
		ans = (ans + curr[1][2]) % MOD;

		return ans;

	}
}