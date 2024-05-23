package Medium.no2597;

import java.util.Arrays;

class Solution {

	public int beautifulSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		return dfs(nums, new boolean[1001], k, 0, 0);
	}

	private int dfs(int[] nums, boolean[] visit, int k, int idx, int cnt) {

		if (idx == nums.length) {
			return cnt == 0 ? 0 : 1;
		}

		int result = dfs(nums, visit, k, idx + 1, cnt);
		if (nums[idx] < k || !visit[nums[idx] - k]) {
			visit[nums[idx]] = true;
			result += dfs(nums, visit, k, idx + 1, cnt + 1);
			visit[nums[idx]] = false;
		}
		return result;

	}
}