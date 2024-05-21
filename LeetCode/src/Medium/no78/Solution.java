package Medium.no78;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>();

		dfs(ans, nums, new boolean[nums.length], 0);

		return ans;
	}

	private void dfs(List<List<Integer>> container, int[] nums, boolean[] flags, int idx) {

		if (idx == nums.length) {
			List<Integer> item = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (flags[i]) {
					item.add(nums[i]);
				}
			}
			container.add(item);
		} else {
			dfs(container, nums, flags, idx + 1);
			flags[idx] = true;
			dfs(container, nums, flags, idx + 1);
			flags[idx] = false;
		}

	}
}