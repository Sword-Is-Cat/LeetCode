package Medium.no1838;

import java.util.Arrays;

class Solution {
	public int maxFrequency(int[] nums, int k) {

		Arrays.sort(nums);

		long sum = k;
		int left = -1, ans = 0;

		for (int right = 0; right < nums.length; right++) {

			sum += nums[right];

			while (sum < (long) nums[right] * (right - left)) {
				sum -= nums[++left];
			}

			ans = Math.max(ans, right - left);

		}

		return ans;
	}
}