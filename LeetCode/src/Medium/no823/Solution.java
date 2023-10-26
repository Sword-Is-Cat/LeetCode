package Medium.no823;

import java.util.Arrays;

class Solution {
	public int numFactoredBinaryTrees(int[] arr) {

		Arrays.sort(arr);
		final int mod = (int) 1e9 + 7;

		long[] result = new long[arr.length];
		long ans = 0L;

		for (int i = 0; i < arr.length; i++) {

			long value = 1;
			int left = 0, right = i - 1;

			while (left <= right) {

				long product = 1L * arr[left] * arr[right];
				if (product < arr[i])
					left++;
				else if (product > arr[i])
					right--;
				else {
					if (left == right)
						value = (value + result[left] * result[right]) % mod;
					else
						value = (value + result[left] * result[right] * 2) % mod;
					left++;
					right--;
				}

			}
			result[i] = value;
			ans += value;

		}

		return (int) (ans % mod);
	}
}