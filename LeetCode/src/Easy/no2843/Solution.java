package Easy.no2843;

class Solution {
	public int countSymmetricIntegers(int low, int high) {
		int answer = 0;
		for (int num = low; num <= high; num++) {
			if (checkSymmetric2(num))
				answer++;
		}
		return answer;
	}

	private boolean checkSymmetric(int num) {
		if (num < 10) {
			return false;
		} else if (num < 100) {
			return num % 11 == 0;
		} else if (num < 1000) {
			return false;
		} else if (num < 10000) {
			return num / 1000 + num / 100 % 10 == num / 10 % 10 + num % 10;
		} else {
			return false;
		}
	}

	private boolean checkSymmetric2(int num) {
		int temp = 1, length = 0;
		while (temp <= num) {
			temp *= 10;
			length++;
		}

		if (length % 2 == 1)
			return false;

		temp = 0;
		for (int i = 0; i < length; i++) {
			if (i < length / 2)
				temp += num % 10;
			else
				temp -= num % 10;
			num /= 10;
		}

		return temp == 0;
	}
}