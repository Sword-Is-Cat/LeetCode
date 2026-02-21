package Easy.no762;

class Solution {
	public int countPrimeSetBits(int left, int right) {
		int ans = 0;
		for (int num = left; num <= right; num++) {
			if (isPrime(Integer.bitCount(num)))
				ans++;
		}
		return ans;
	}

	private boolean isPrime(int num) {
		switch (num) {
		case 2:
		case 3:
		case 5:
		case 7:
		case 11:
		case 13:
		case 17:
		case 19:
		case 23:
			return true;
		default:
			return false;
		}
	}
}