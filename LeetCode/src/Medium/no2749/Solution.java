package Medium.no2749;

class Solution {
	public int makeTheIntegerZero(int num1, int num2) {

		int cnt = 0;
		long temp = -1;
		while (cnt < Long.bitCount(temp)) {
			cnt++;
			temp = num1 - (long) num2 * cnt;
			if (temp < cnt)
				return -1;
		}

		return cnt;
	}
}