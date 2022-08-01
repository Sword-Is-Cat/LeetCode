package Medium.no62;

class Solution {
	public int uniquePaths(int m, int n) {

		return combination(--m + --n, Math.min(m, n));

	}

	public int combination(int sum, int no) {

		long result = 1;
		int i = 1;

		while (i <= no)
			result = result * sum-- / i++;

		return (int) result;
	}
}