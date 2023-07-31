package Medium.no712;

class Solution {

	char[] arr1, arr2;
	int[][] cache;

	public int minimumDeleteSum(String s1, String s2) {

		arr1 = s1.toCharArray();
		arr2 = s2.toCharArray();
		cache = new int[arr1.length + 1][arr2.length + 1];

		return dp(0, 0);
	}

	private int dp(int idx1, int idx2) {

		if (idx1 == arr1.length && idx2 == arr2.length)
			return 0;

		if (cache[idx1][idx2] == 0) {

			int value = 0;

			if (idx1 == arr1.length) {
				value = arr2[idx2] + dp(idx1, idx2 + 1);
			} else if (idx2 == arr2.length) {
				value = arr1[idx1] + dp(idx1 + 1, idx2);
			} else if (arr1[idx1] == arr2[idx2]) {
				value = dp(idx1 + 1, idx2 + 1);
			} else {
				int del1 = arr1[idx1] + dp(idx1 + 1, idx2);
				int del2 = arr2[idx2] + dp(idx1, idx2 + 1);
				value = Math.min(del1, del2);
			}

			cache[idx1][idx2] = value;

		}
		return cache[idx1][idx2];
	}
}