package Easy.no1716;

class Solution {
	public int totalMoney(int n) {

		int[] accum = { 0, 1, 3, 6, 10, 15, 21 };
		int weeks = n / 7, dates = n % 7;

		return weeks * 28 + weeks * (weeks - 1) * 7 / 2 + accum[dates] + dates * weeks;//

	}
}