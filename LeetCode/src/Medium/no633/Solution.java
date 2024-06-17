package Medium.no633;

class Solution {
	public boolean judgeSquareSum(int c) {

		boolean ans = false;
		for (long i = 0; !ans && i * i <= c; i++) {
			ans |= isSquare(c - i * i);
		}

		return ans;
	}

	private boolean isSquare(long num) {
		long rt = (long) Math.sqrt(num);
		return rt * rt == num;
	}
}