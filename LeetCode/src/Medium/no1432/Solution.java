package Medium.no1432;

class Solution {

	public int maxDiff(int num) {

		int limit = 1;
		while (limit * 10 <= num)
			limit *= 10;

		int max = num, min = num;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int val = remapDigit(num, i, j);
				if (val >= limit) {
					max = Math.max(max, val);
					min = Math.min(min, val);
				}
			}
		}
		return max - min;

	}

	private int remapDigit(int num, int from, int to) {
		if (num == 0 || from == to)
			return num;
		int digit = num % 10;
		if (digit == from)
			digit = to;
		int result = remapDigit(num / 10, from, to);
		return result * 10 + digit;
	}

}