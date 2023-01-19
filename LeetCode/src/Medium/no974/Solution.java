package Medium.no974;

import java.util.Arrays;

class Solution {
	public int subarraysDivByK(int[] nums, int k) {

		int[] cnts = new int[k];
		cnts[0]++;

		for (int i = 0; i < nums.length; i++) {
			if (i > 0)
				nums[i] += nums[i - 1];
			nums[i] %= k;
			if (nums[i] < 0)
				nums[i] += k;
			cnts[nums[i]]++;
		}

		return Arrays.stream(cnts).map(i -> i * (i - 1) / 2).sum();
	}
}