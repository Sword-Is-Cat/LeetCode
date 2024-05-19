package Hard.no3068;

class Solution {
	public long maximumValueSum(int[] nums, int k, int[][] edges) {

		long sum = 0L;
		int plusMin = Integer.MAX_VALUE, nonPlusMax = Integer.MIN_VALUE;
		int plusCnt = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = (nums[i] ^ k) - nums[i];
			if (temp > 0) {
				sum += temp;
				plusCnt++;
				plusMin = Math.min(plusMin, temp);
			} else {
				nonPlusMax = Math.max(nonPlusMax, temp);
			}
		}

		if (plusCnt % 2 == 1) {
			if (plusMin + nonPlusMax > 0) {
				sum += nonPlusMax;
			} else {
				sum -= plusMin;
			}
		}

		return sum;

	}
}