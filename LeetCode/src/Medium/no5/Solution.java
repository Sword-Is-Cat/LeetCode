package Medium.no5;

class Solution {

	char[] arr;
	int cFrom = 0;
	int cTo = -1;

	public String longestPalindrome(String s) {

		arr = s.toCharArray();

		process(0, 0);

		for (int i = 1; i < s.length(); i++) {
			process(i - 1, i);
			process(i, i);
		}

		StringBuilder sb = new StringBuilder();

		while (cFrom <= cTo)
			sb.append(arr[cFrom++]);

		return sb.toString();
	}

	void process(int from, int to) {

		if (from >= 0 && to < arr.length) {

			if (arr[from] == arr[to]) {

				if (cTo - cFrom < to - from) {
					cFrom = from;
					cTo = to;
				}
				process(from - 1, to + 1);
			}
		}
	}
}