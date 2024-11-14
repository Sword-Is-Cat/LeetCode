package Medium.no2064;

class Solution {
	public int minimizedMaximum(int n, int[] quantities) {

		int left = 0, right = 100000;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (checkPossible(n, quantities, mid))
				left = mid;
			else
				right = mid;
		}

		return right;
	}

	private boolean checkPossible(int n, int[] quanti, int value) {

		int cnt = 0;

		for (int q : quanti) {
			cnt += (q - 1) / value + 1;
		}

		return cnt > n;
	}
}