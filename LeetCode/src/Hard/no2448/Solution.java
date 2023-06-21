package Hard.no2448;

import java.util.Arrays;

class Solution {
	public long minCost(int[] nums, int[] cost) {

		int length = nums.length;
		int[][] array = new int[length][];
		long costHead = 0, costTail = 0;
		for (int i = 0; i < length; i++) {
			costTail += cost[i];
			array[i] = new int[] { nums[i], cost[i] };
		}

		Arrays.sort(array, (a, b) -> (a[0] - b[0]));

		long ans, costSum = 0;

		for (int i = 0; i < length; i++) {
			costSum += 1L * (array[i][0] - array[0][0]) * array[i][1];
		}

		ans = costSum;

		for (int i = 1; i < length; i++) {

			int move = array[i][0] - array[i - 1][0];

			costHead += array[i - 1][1];
			costTail -= array[i - 1][1];
			costSum = costSum + (move * costHead) - (move * costTail);
			ans = Math.min(ans, costSum);
		}

		return ans;
	}
}