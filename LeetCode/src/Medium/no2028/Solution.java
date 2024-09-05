package Medium.no2028;

class Solution {
	public int[] missingRolls(int[] rolls, int mean, int n) {

		int sum = mean * (rolls.length + n);
		for (int roll : rolls)
			sum -= roll;

		if (sum < n || sum > n * 6)
			return new int[0];

		int[] answer = new int[n];

		int div = sum / n, mod = sum % n;

		for (int i = 0; i < n; i++)
			answer[i] = (i < mod ? 1 : 0) + div;

		return answer;
	}
}