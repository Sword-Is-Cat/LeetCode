package Easy.no2099;

import java.util.Arrays;

class Solution {
	public int[] maxSubsequence(int[] nums, int k) {

		int[] ans = new int[k];
		int[][] infos = new int[nums.length][];
		for (int i = 0; i < nums.length; i++)
			infos[i] = new int[] { i, nums[i] };

		Arrays.sort(infos, (a, b) -> b[1] - a[1]);

		int[][] results = Arrays.copyOfRange(infos, 0, k);
		Arrays.sort(results, (a, b) -> a[0] - b[0]);

		for (int i = 0; i < k; i++)
			ans[i] = results[i][1];

		return ans;
	}
}