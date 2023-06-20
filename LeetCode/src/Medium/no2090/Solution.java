package Medium.no2090;

class Solution {
	public int[] getAverages(int[] nums, int k) {

		int length = nums.length;
		long[] sum = new long[length];

		for (int i = 0; i < length && i < k; i++) {
			sum[0] += nums[i];
		}

		for (int i = 0; i < length; i++) {

			if (0 < i)
				sum[i] = sum[i - 1];

			if (i + k < length)
				sum[i] += nums[i + k];

			if (k < i)
				sum[i] -= nums[i - k - 1];

		}

		for (int i = 0; i < length; i++) {
			if (i < k || length <= i + k)
				nums[i] = -1;
			else
				nums[i] = (int)(sum[i] / (k * 2 + 1));
		}

		return nums;
	}
}