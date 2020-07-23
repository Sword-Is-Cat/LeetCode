package Easy.no204;

class Solution {
	public int countPrimes(int n) {

		n--;
		if (n < 2)
			return 0;

		int answer = 0;
		boolean[] primes = new boolean[n];

		primes[0] = true;
		for (int i = 1; i < n; i++) {

			if (!primes[i]) {

				answer++;
				int j = i;
				while (j < n) {
					primes[j] = true;
					j += i + 1;
				}

			}

		}

		return answer;
	}
}