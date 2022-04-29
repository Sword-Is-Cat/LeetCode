package Medium.no50;

class Solution {
	public double myPow(double x, int n) {

		if (n == 0)
			return 1;
		else if (x == 1D || x == 0D)
			return x;

		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		return n > 0 ? myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : x) : myPow(x * x, -(n / 2)) * (n % 2 == 0 ? 1 : x);
	}
}