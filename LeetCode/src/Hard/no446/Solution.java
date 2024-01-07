package Hard.no446;

import java.util.HashMap;

class Solution {
	public int numberOfArithmeticSlices(int[] nums) {

		int length = nums.length, ans = 0;
		HashMap<Integer, Integer>[] dp = new HashMap[length];

		for (int i = 0; i < length; i++) {
			dp[i] = new HashMap<>();
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {

				long dif = (long) nums[i] - nums[j];

				if (Integer.MAX_VALUE < dif || dif < Integer.MIN_VALUE)
					continue;

				int diff = (int) dif;

				dp[i].put(diff, dp[i].getOrDefault(diff, 0) + 1);
				if (dp[j].containsKey(diff)) {
					ans += dp[j].get(diff);
					dp[i].put(diff, dp[i].get(diff) + dp[j].get(diff));
				}

			}
		}

		return ans;

	}
}