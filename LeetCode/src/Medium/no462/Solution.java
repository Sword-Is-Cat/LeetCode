package Medium.no462;

import java.util.Arrays;

class Solution {
	public int minMoves2(int[] nums) {

		Arrays.sort(nums);

		int stand = nums[nums.length / 2], ans = 0;

		for (int no : nums)
			ans += Math.abs(no - stand);

		return ans;
	}
}