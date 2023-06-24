package Hard.no956;

import java.util.Arrays;

class Solution {
	public int tallestBillboard(int[] rods) {

		int sum = Arrays.stream(rods).sum();
		int[] dp = new int[sum + 1];

		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int rod : rods) {

			int[] copy = dp.clone();

			for (int prevDif = 0; prevDif + rod <= sum; prevDif++) {

				if (copy[prevDif] < 0)
					continue;

				dp[rod + prevDif] = Math.max(dp[rod + prevDif], copy[prevDif]);
				int newDif = Math.abs(prevDif - rod);
				dp[newDif] = Math.max(dp[newDif], copy[prevDif] + Math.min(prevDif, rod));

			}
		}
		return dp[0];
	}
}