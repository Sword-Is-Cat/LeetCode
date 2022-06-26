package Medium.no647;

class Solution {
	public int countSubstrings(String s) {

		char[] arr = s.toCharArray();
		boolean[][] visit = new boolean[arr.length][arr.length];
		boolean[][] cache = new boolean[arr.length][arr.length];

		int cnt = 0;

		for (int left = 0; left < arr.length; left++) {
			for (int right = left; right < arr.length; right++) {
				if (isPalindrom(arr, left, right, visit, cache))
					cnt++;
			}
		}

		return cnt;
	}

	boolean isPalindrom(char[] arr, int left, int right, boolean[][] visit, boolean[][] cache) {

		if (!visit[left][right]) {

			boolean result = false;

			if (left >= right) {
				result = true;
			} else {
				result = arr[left] == arr[right] && isPalindrom(arr, left + 1, right - 1, visit, cache);
			}

			cache[left][right] = result;
			visit[left][right] = true;
		}

		return cache[left][right];
	}

}