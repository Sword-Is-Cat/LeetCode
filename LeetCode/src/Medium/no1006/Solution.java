package Medium.no1006;

class Solution {

	int[] cases = { 0, 1, 2, 6 };

	public int clumsy(int n) {

		int result = 0;

		if (n > 3)
			result = n-- * n-- / n-- + n--;
		else {
			return cases[n];
		}

		while (n > 3) {
			result -= n-- * n-- / n--;
			result += n--;
		}

		return result - cases[n];
	}
}