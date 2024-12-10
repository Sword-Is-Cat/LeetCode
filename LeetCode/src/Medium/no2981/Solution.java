package Medium.no2981;

class Solution {
	public int maximumLength(String s) {

		char[] arr = s.toCharArray();
		int pos = 0, imp = s.length() + 1;
		while (pos + 1 < imp) {
			int mid = (pos + imp) / 2;
			if (occurThrice(arr, mid)) {
				pos = mid;
			} else {
				imp = mid;
			}
		}

		return pos == 0 ? -1 : pos;
	}

	private boolean occurThrice(char[] arr, int length) {

		int[] counter = new int[26];

		char prev = ' ';
		int cnt = 0;

		for (char ch : arr) {

			if (prev == ch) {
				cnt++;
			} else {
				prev = ch;
				cnt = 1;
			}

			if (cnt >= length) {
				counter[ch - 'a']++;
			}

			if (counter[ch - 'a'] > 2)
				return true;

		}

		return false;
	}
}