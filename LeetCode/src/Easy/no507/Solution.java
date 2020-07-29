package Easy.no507;

class Solution {
	public boolean checkPerfectNumber(int num) {

		if (num == 1)
			return false;

		int sum = 1;

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0 && i * i != num) {
				sum += i;
				sum += num / i;
			} else if (i * i == num)
				sum += i;
		}

		if (sum == num)
			return true;
		else
			return false;

	}
}