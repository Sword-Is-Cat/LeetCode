package Easy.no50;

class Solution {
	public double myPow(double x, int n) {

		if (n == Integer.MIN_VALUE)
			return myPow(x, n + 1) / x;

		if (n < 0)
			return 1 / myPow(x, -n);

		if (n == 0)
			return 1;

		if (n > 2)
			return myPow(myPow(x, n / 2), 2) * myPow(x, n % 2);

		return n == 1 ? x : (x * x);
	}
}