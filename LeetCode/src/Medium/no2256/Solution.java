package Medium.no2256;

class Solution {
	public int minimumAverageDifference(int[] nums) {

		long sum = 0;
		int length = nums.length;
		long[] sums = new long[length];
		for (int i = 0; i < length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}

		int idx = 0, temp = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < length; i++) {
			if (i == length - 1)
				temp = (int) (sum / length);
			else
				temp = (int) Math.abs((sums[i] / (i + 1)) - ((sum - sums[i]) / (length - i - 1)));
			if (temp < min) {
				min = temp;
				idx = i;
			}
		}
		return idx;
	}
}