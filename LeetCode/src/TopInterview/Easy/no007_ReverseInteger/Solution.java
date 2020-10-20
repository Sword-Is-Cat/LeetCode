package TopInterview.Easy.no007_ReverseInteger;

class Solution {
	public int reverse(int x) {

		int minus = 1;

		if (x < 0) {
			minus = -1;
			x *= -1;
		}

		long answer = 0;

		while (x > 0) {
			answer *= 10;
			answer += x % 10;
			x /= 10;
		}

		return answer > Integer.MAX_VALUE ? 0 : (int) answer * minus;
	}
}