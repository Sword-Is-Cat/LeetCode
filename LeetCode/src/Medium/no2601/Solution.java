package Medium.no2601;

import java.util.Arrays;

class Solution {
	public boolean primeSubOperation(int[] nums) {

		boolean[] primes = new boolean[maxElement(nums) + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int prime = 2; prime * prime < primes.length; prime++) {
			if (primes[prime]) {
				for (int n = 2; n * prime < primes.length; n++) {
					primes[n * prime] = false;
				}
			}
		}

		for (int i = nums.length - 2; i >= 0; i--) {

			if (nums[i] < nums[i + 1])
				continue;

			int minPrime = 0;
			for (int prime = nums[i] - nums[i + 1] + 1; prime < nums[i]; prime++) {
				if (primes[prime]) {
					minPrime = prime;
					break;
				}
			}

			if (minPrime == 0)
				return false;
			nums[i] -= minPrime;

		}

		return true;
	}

	private int maxElement(int[] nums) {
		int result = nums.length > 0 ? nums[0] : 0;
		for (int num : nums)
			result = Math.max(result, num);
		return result;
	}
}