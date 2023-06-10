package Medium.no1802;

class Solution {

	public int maxValue(int length, int index, int maxSum) {

		int left = 1, right = maxSum + 1;

		while (left + 1 < right) {

			int mid = (left + right) / 2;

			if (calcMinSum(length, index, mid) <= maxSum)
				left = mid;
			else
				right = mid;

		}

		return left;
	}

	private long calcMinSum(int length, int index, int value) {

		return calcOneSideSum(index, value) + calcOneSideSum(length - index - 1, value) + value;
	}

	private long calcOneSideSum(int length, int value) {

		long result = 0;

		if (length < value) {
			result = (long) length * (2 * value - length - 1) / 2;
		} else {
			result = (long) value * (value - 1) / 2 + length - value + 1;
		}

		return result;
	}

}