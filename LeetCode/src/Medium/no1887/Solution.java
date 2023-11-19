package Medium.no1887;

import java.util.Arrays;

class Solution {
	public int reductionOperations(int[] nums) {

		Arrays.sort(nums);

		int ans = 0, cnt = 0, last = 0;

		for (int i = nums.length - 1; i > -1; i--) {
			int num = nums[i];

			if (last != num) {
				ans += cnt;
				last = num;
			}

			cnt++;
		}

		return ans;
	}
}