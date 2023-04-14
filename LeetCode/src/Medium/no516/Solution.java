package Medium.no516;

class Solution {

	char[] strArr;
	int[][] dpCache;

	public int longestPalindromeSubseq(String s) {

		strArr = s.toCharArray();
		dpCache = new int[strArr.length][strArr.length];

		return process(0, strArr.length - 1);

	}

	private int process(int s, int e) {

		if (s > e) {
			// invalid
			return 0;
		}

		if (dpCache[s][e] == 0) {

			if (s == e) {
				// single char
				dpCache[s][e] = 1;
			} else if (strArr[s] == strArr[e]) {
				dpCache[s][e] = process(s + 1, e - 1) + 2;
			} else {
				dpCache[s][e] = Math.max(process(s + 1, e), process(s, e - 1));
			}

		}
		return dpCache[s][e];
	}
}