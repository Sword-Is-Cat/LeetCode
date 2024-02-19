package Easy.no231;

class Solution_ {
	public boolean isPowerOfTwo(int n) {

		if (n < 1)
			return false;

		boolean answer = true;

		while (n > 1) {

			if (n % 2 == 1) {
				answer = false;
				break;
			}

			n /= 2;
		}

		return answer;

	}
}