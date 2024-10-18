package Medium.no2044;

class Solution {

	public int countMaxOrSubsets(int[] nums) {

		int[] rightOr = nums.clone();
		for (int i = nums.length - 2; i >= 0; i--) {
			rightOr[i] |= rightOr[i + 1];
		}

		return dfs(nums, rightOr, rightOr[0], 0, 0);
	}

	private int dfs(int[] nums, int[] rightOr, int maxOr, int idx, int currVal) {

		if (maxOr == currVal) {
			return 1 << nums.length - idx;
		}

		if (idx == nums.length) {
			return 0;
		}

		if ((currVal | rightOr[idx]) != maxOr) {
			return 0;
		}

		return dfs(nums, rightOr, maxOr, idx + 1, currVal) + dfs(nums, rightOr, maxOr, idx + 1, currVal | nums[idx]);

	}

}