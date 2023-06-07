package Medium.no1318;

class Solution {
	public int minFlips(int a, int b, int c) {

		int flip = 0;

		while (a > 0 || b > 0 || c > 0) {

			if (c % 2 == 0) {
				flip += a % 2 + b % 2;
			} else {
				flip += a % 2 + b % 2 > 0 ? 0 : 1;
			}

			a >>= 1;
			b >>= 1;
			c >>= 1;

		}

		return flip;

	}
}