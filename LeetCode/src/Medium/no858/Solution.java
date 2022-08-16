package Medium.no858;

class Solution {

	public int mirrorReflection(int p, int q) {

		int[][] rst = { { -1, 0 }, { 2, 1 } };

		int lcd = lcd(p, q);
		int col = lcd / q;
		int row = lcd / p;

		return rst[row % 2][col % 2];

	}

	int gcd(int a, int b) {
		int m = a % b;
		return m == 0 ? b : gcd(b, m);
	}

	int lcd(int a, int b) {
		return a * b / gcd(a, b);
	}

}