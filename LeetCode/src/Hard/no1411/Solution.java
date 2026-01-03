package Hard.no1411;

class Solution {
	public int numOfWays(int n) {

		final int MOD = 1_000_000_007;

		long[] curr = { 6, 6 }, prev;
		while (--n > 0) {
			prev = curr;
			curr = new long[2];
			curr[0] = (3 * prev[0] + 2 * prev[1]) % MOD;
			curr[1] = (2 * prev[0] + 2 * prev[1]) % MOD;
		}
		return (int) ((curr[0] + curr[1]) % MOD);
	}
}