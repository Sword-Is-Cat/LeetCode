package Easy.no1470;

class Solution {
	public int[] shuffle(int[] nums, int n) {

		int[] ans = new int[nums.length];

		for (int i = 0; i < ans.length; i++)
			ans[i] = i % 2 == 0 ? nums[i / 2] : nums[i / 2 + n];

		return ans;

	}
}