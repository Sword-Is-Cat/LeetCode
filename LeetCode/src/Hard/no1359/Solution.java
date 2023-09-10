package Hard.no1359;

class Solution {

	final int mod = (int) 1e9 + 7;

	public int countOrders(int n) {

		if (n == 1)
			return 1;

		long result = countOrders(n - 1);

		result *= n * (2 * n - 1);

		return (int) (result % mod);

	}
}