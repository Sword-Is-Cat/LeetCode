package Hard.no1402;

import java.util.Arrays;

class Solution {
	public int maxSatisfaction(int[] satisfaction) {

		Arrays.sort(satisfaction);

		int ans = 0, sum = 0;

		for (int i = satisfaction.length - 1; i >= 0; i--) {
			sum += satisfaction[i];
			if (sum > 0)
				ans += sum;
			else
				break;
		}

		return ans;
	}
}