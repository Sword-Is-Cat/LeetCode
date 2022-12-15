package Medium.no1143;

class Solution {

	char[] array1, array2;
	int[][] cache;

	public int longestCommonSubsequence(String text1, String text2) {

		array1 = text1.toCharArray();
		array2 = text2.toCharArray();
		cache = new int[array1.length][array2.length];

		return dfs(0, 0);
	}

	public int dfs(int idx1, int idx2) {

		if (idx1 == array1.length || idx2 == array2.length)
			return 0;

		if (cache[idx1][idx2] == 0) {

			int result = 0;

			if (array1[idx1] == array2[idx2]) {
				result = 1 + dfs(idx1 + 1, idx2 + 1);
			} else {
				result = Math.max(dfs(idx1 + 1, idx2), dfs(idx1, idx2 + 1));
			}

			cache[idx1][idx2] = result;
		}
		return cache[idx1][idx2];
	}
}