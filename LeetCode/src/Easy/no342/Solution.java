package Easy.no342;

class Solution {
	public boolean isPowerOfFour(int num) {

		if (num < 1)
			return false;

		boolean answer = true;

		while (num > 1) {
			if (num % 4 != 0) {
				answer = false;
				break;
			} else
				num /= 4;
		}

		return answer;

	}
}