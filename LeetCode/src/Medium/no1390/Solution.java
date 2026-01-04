package Medium.no1390;

class Solution {
	public int sumFourDivisors(int[] nums) {
		int result = 0;
		for (int num : nums) {
			if (countDivisors(num) == 4) {
				result += sumOfDivisors(num);
			}
		}
		return result;
	}

	private int sumOfDivisors(int num) {
		for (int d = 2; d < 320; d++) {
			if (num % d == 0)
				return 1 + d + (num / d) + num;
		}
		return -1;
	}

	private int countDivisors(int num) {
		int result = 1;
		for (int d = 2; d <= 320; d++) {
			int temp = 1;
			while (num % d == 0) {
				num /= d;
				temp++;
			}
			result *= temp;
		}
		return num == 1 ? result : result * 2;
	}
}