package Medium.no2698;

class Solution {

	public int punishmentNumber(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (isPunishment(i)) {
				answer += i * i;
			}
		}
		return answer;
	}

	private boolean isPunishment(int num) {
		return isPunishment(num, 0, num * num);
	}

	private boolean isPunishment(int origin, int sum, int product) {

		if (origin < sum)
			return false;
		if (origin == sum && product == 0)
			return true;

		boolean result = false;
		int temp = 1;
		while (temp <= product) {
			result |= isPunishment(origin, sum + product / temp, product % temp);
			temp *= 10;
		}
		return result;
	}
}