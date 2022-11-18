package Medium.no1641;

class Solution {

	int[][] arr;

	public int countVowelStrings(int n) {
		arr = new int[5][51];
		return countUnderInt(4, n);
	}

	int countUnderInt(int k, int n) {

		if (arr[k][n] != 0)
			return arr[k][n];

		int result = 0;
		if (n == 0)
			result += 1;
		else {
			for (int i = 0; i <= k; i++) {
				result += countUnderInt(i, n - 1);
			}
		}

		arr[k][n] = result;
		return result;
	}
}