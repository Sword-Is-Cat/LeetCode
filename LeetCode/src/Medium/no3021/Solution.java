package Medium.no3021;

class Solution {
	public long flowerGame(int n, int m) {
		long nOdd = (n + 1) / 2, nEven = n / 2, mOdd = (m + 1) / 2, mEven = m / 2;
		return nOdd * mEven + nEven * mOdd;
	}
}