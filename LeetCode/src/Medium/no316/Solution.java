package Medium.no316;

class Solution {

	char[] arr;
	boolean[] used;
	int init = 0;

	public String removeDuplicateLetters(String s) {

		arr = s.toCharArray();
		used = new boolean[26];
		StringBuilder sb = new StringBuilder();

		boolean[] check = new boolean[26];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!check[arr[i] - 'a']) {
				check[arr[i] - 'a'] = true;
				cnt++;
			}
		}

		while (cnt > 0) {
			sb.append(findFisrtChar(cnt--));
		}

		return sb.toString();
	}

	private char findFisrtChar(int cnt) {

		boolean[] check = new boolean[26];

		char rst = 'z';
		int index = arr.length;

		for (int i = arr.length - 1; i >= init; i--) {
			char ch = arr[i];
			int idx = ch - 'a';
			if (!used[idx]) {
				if (!check[idx]) {
					check[idx] = true;
					cnt--;
				}
				if (cnt == 0) {
					if (ch <= rst) {
						rst = ch;
						index = i;
					}
				}
			}
		}

		init = index;
		used[rst - 'a'] = true;

		return rst;
	}
}