package Medium.no2601;

import java.util.Arrays;

class Solution {
	public boolean primeSubOperation(int[] nums) {

		boolean[] primes = new boolean[maxElement(nums) + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int num = 2; num * num < primes.length; num++) {
			if (primes[num]) {
				for (int n = 2; n * num < primes.length; n++) {
					primes[n * num] = false;
				}
			}
		}

		for (int i = nums.length - 2; i >= 0; i--) {

			if (nums[i] < nums[i + 1])
				continue;

			int minPrime = 0;
			for (int p = nums[i] - nums[i + 1] + 1; p < nums[i]; p++) {
				if (primes[p]) {
					minPrime = p;
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
		int result = nums[0];
		for (int i = 1; i < nums.length; i++)
			result = Math.max(result, nums[i]);
		return result;
	}
}