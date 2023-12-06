package Easy.no1716;

class Solution {
	public int totalMoney(int n) {

		int[] sums = { 0, 1, 3, 6, 10, 15, 21 };

		int fullWeeks = n / 7, dates = n % 7;

		int sum = 0;

		sum += fullWeeks * 28 + fullWeeks * (fullWeeks - 1) * 7 / 2;
		sum += sums[dates] + dates * fullWeeks;

		return sum;

	}
}