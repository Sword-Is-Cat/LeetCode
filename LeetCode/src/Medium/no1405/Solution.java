package Medium.no1405;

class Solution {
	public String longestDiverseString(int a, int b, int c) {

		StringBuilder sb = new StringBuilder();
		int[] remain = { a, b, c }, stack = { 0, 0, 0 };

		while (!isAllZero(remain)) {
			char next = getNextChar(remain, stack);
			if (next < 'a') {
				break;
			}
			sb.append(next);
		}

		return sb.toString();
	}

	private char getNextChar(int[] remain, int[] stack) {

		int idx = -1, cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (stack[i] < 2 && remain[i] > cnt) {
				idx = i;
				cnt = remain[i];
			}
		}
		for (int i = 0; i < 3; i++) {
			if (i == idx) {
				remain[i]--;
				stack[i]++;
			} else {
				stack[i] = 0;
			}
		}

		return (char) ('a' + idx);
	}

	private boolean isAllZero(int[] remain) {
		boolean result = true;
		for (int num : remain)
			result &= num == 0;
		return result;
	}
}