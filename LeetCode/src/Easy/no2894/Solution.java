package Easy.no2894;

class Solution {
	public int differenceOfSums(int n, int m) {
		return sumToN(n) - 2 * sumToN(n / m) * m;
	}

	private int sumToN(int n) {
		return n * (n + 1) / 2;
	}
}