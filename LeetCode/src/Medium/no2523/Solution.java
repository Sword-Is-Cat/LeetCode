package Medium.no2523;

import java.util.Arrays;

class Solution {
	public int[] closestPrimes(int left, int right) {

		boolean[] isPrime = new boolean[right + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		int[] answer = { -1, -1 };
		int prevPrime = 0;

		for (int num = 2; num < isPrime.length; num++) {

			if (isPrime[num]) {

				if (num >= left) {
					if (prevPrime != 0) {

						if (answer[0] == -1 || num - prevPrime < answer[1] - answer[0]) {
							answer = new int[] { prevPrime, num };
						}
					}
					prevPrime = num;
				}


				for (int i = 2; i * num <= right; i++) {
					isPrime[i * num] = false;
				}

			}

		}

		return answer;

	}
}