package Hard.no1411;

class Solution {
	public int numOfWays(int n) {

		final int MOD = 1_000_000_007;

		long a = 6, b = 6;
		while (--n > 0) {
			b = 2 * (a + b) % MOD;
			a = (a + b) % MOD;
		}
		return (int) ((a + b) % MOD);
	}
}