package Medium.no1680;

class Solution {

	final int MOD = 1000000007;
	int[] cache;

	public int concatenatedBinary(int n) {

		long base = 1, answer = 0;
		cache = new int[n + 1];

		while (n > 0) {

			answer += (n * base) % MOD;
			base *= minTwoPow(n);
			base %= MOD;

			n--;
		}

		return (int) (answer % MOD);
	}

	int minTwoPow(int n) {

		if (cache[n] == 0) {

			int result = n > 0 ? 2 * minTwoPow(n / 2) : 1;
			cache[n] = result;

		}

		return cache[n];
	}
}