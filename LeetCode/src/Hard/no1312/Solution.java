package Hard.no1312;

class Solution {

	char[] arr;
	Integer[][] cache;

	public int minInsertions(String s) {

		arr = s.toCharArray();
		cache = new Integer[arr.length][arr.length];

		return countInsertions(0, arr.length - 1);
	}

	private int countInsertions(int left, int right) {

		if (left >= right) {
			// single letter or no remain letter
			return 0;
		}

		if (cache[left][right] == null) {
			int rst;
			if (arr[left] == arr[right]) {
				// left-end letter eq right-end letter
				rst = countInsertions(left + 1, right - 1);
			} else {
				// compare left-insert case and right-insert case
				int insertAtLeft = countInsertions(left, right - 1) + 1;
				int insertAtRight = countInsertions(left + 1, right) + 1;
				rst = Math.min(insertAtLeft, insertAtRight);
			}
			cache[left][right] = rst;
		}

		return cache[left][right];
	}
}