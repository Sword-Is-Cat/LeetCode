package Easy.no1863;

class Solution {
	public int subsetXORSum(int[] nums) {

		return dfs(nums, 0, 0);

	}

	private int dfs(int[] nums, int idx, int value) {

		if (idx == nums.length) {
			return value;
		}

		return dfs(nums, idx + 1, value) + dfs(nums, idx + 1, value ^ nums[idx]);

	}
}