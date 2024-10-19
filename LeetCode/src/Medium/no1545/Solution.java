package Medium.no1545;

class Solution {
	public char findKthBit(int n, int k) {
		return (char) ('0' + findKthBit(k - 1));
	}

	private int findKthBit(int k) {

		if (k < 2) {
			return k;
		}

		int mid = Integer.MAX_VALUE;
		while (mid > k) {
			mid >>= 1;
		}

		if (mid == k) {
			return 1;
		}

		return 1 - findKthBit(2 * mid - k);
	}
}