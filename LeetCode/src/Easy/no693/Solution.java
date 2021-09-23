package Easy.no693;

class Solution {
	public boolean hasAlternatingBits(int n) {

		if (n % 2 == 0)
			n /= 2;

		while (n % 4 == 1) {
			n /= 4;
		}

		return n == 0;
	}
}