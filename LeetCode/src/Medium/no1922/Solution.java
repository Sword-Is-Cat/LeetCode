package Medium.no1922;

class Solution {

	final static int MOD = (int) 1e9 + 7;

	public int countGoodNumbers(long n) {

		long rst = customPow(20L, n / 2);
		if (n % 2 == 1) {
			rst = (rst * 5) % MOD;
		}

		return (int) rst;

	}

	private long customPow(long a, long b) {
		if (b == 0)
			return 1L;
		if (b == 1)
			return a;
		long rst = customPow(a, b / 2);
		rst = (rst * rst) % MOD;
		return b % 2 == 1 ? (rst * a) % MOD : rst;
	}
}