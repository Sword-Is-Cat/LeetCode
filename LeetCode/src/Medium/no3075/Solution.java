package Medium.no3075;

import java.util.Arrays;

class Solution {
	public long maximumHappinessSum(int[] happiness, int k) {

		Arrays.sort(happiness);

		long ans = 0L;

		for (int i = 0; i < k; i++) {
			if (happiness[happiness.length - 1 - i] > i) {
				ans += happiness[happiness.length - 1 - i] - i;
			} else {
				break;
			}
		}

		return ans;
	}
}
