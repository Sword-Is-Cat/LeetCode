package Medium.no474;

class Solution {

	int[][] counter;
	Integer[][][] cache;

	public int findMaxForm(String[] strs, int m, int n) {

		counter = new int[strs.length][2];
		cache = new Integer[strs.length + 1][m + 1][n + 1];

		for (int i = 0; i < strs.length; i++) {

			String k = strs[i];

			for (char c : k.toCharArray()) {
				if (c == '0')
					counter[i][0]++;
				else
					counter[i][1]++;

			}
		}

		return cacheDfs(0, m, n);
	}

	private int cacheDfs(int idx, int m, int n) {

		if (m < 0 || n < 0) {
			return Integer.MIN_VALUE;

		} else if (idx == counter.length) {
			return 0;

		} else if (cache[idx][m][n] != null) {
			return cache[idx][m][n];

		} else {

			int pick = 1 + cacheDfs(idx + 1, m - counter[idx][0], n - counter[idx][1]);
			int nonPick = cacheDfs(idx + 1, m, n);
			cache[idx][m][n] = Math.max(pick, nonPick);
			return cache[idx][m][n];
		}
	}
}