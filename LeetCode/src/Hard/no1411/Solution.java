package Hard.no1411;

class Solution {
	public int numOfWays(int n) {

		final int MOD = 1_000_000_007;

		long ryr = 6, ryg = 6;
		while (--n > 0) {
			long newRyr = (3 * ryr + 2 * ryg) % MOD;
			long newRyg = (2 * ryr + 2 * ryg) % MOD;
			ryr = newRyr;
			ryg = newRyg;
		}
		return (int) ((ryr + ryg) % MOD);
	}
}