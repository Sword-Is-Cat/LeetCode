package Easy.no746;

class Solution {
	public int minCostClimbingStairs(int[] cost) {

		int[] sum = new int[cost.length + 1];

		sum[0] = cost[0];
		sum[1] = cost[1];

		for (int i = 2; i < sum.length; i++) 
			sum[i] = Math.min(sum[i - 1], sum[i - 2]) + i == cost.length ? 0 : cost[i];

		return sum[cost.length];
	}
}