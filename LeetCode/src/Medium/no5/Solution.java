package Medium.no5;

class Solution {

	String str;
	int cFrom = 0;
	int cTo = 0;

	public String longestPalindrome(String s) {

		str = s;

		process(0, 0);

		for (int i = 1; i < str.length(); i++) {
			process(i - 1, i);
			process(i, i);
		}

		return str.substring(cFrom, cTo + 1);
	}

	void process(int from, int to) {

		if (from >= 0 && to < str.length()) {

			if (str.charAt(from) == str.charAt(to)) {

				if (cTo - cFrom < to - from) {
					cFrom = from;
					cTo = to;
				}
				process(from - 1, to + 1);
			}
		}
	}
}