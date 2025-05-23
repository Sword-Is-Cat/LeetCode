package Hard.no3068;

class Solution {
	public long maximumValueSum(int[] nums, int k, int[][] edges) {

		long sum = 0L;
		int mask = 0, maxMinus = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = (nums[i] ^ k) - nums[i];
			if (temp > 0) {
				sum += temp;
				mask ^= 1;
				temp *= -1;
			}
			maxMinus = Math.max(maxMinus, temp);
		}

		return sum + mask * maxMinus;

	}
}