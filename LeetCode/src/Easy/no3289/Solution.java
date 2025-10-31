package Easy.no3289;

class Solution {
	public int[] getSneakyNumbers(int[] nums) {
		int[] ans = { 0, 0 };
		int idx = 0;
		boolean[] visit = new boolean[nums.length - 2];

		for (int num : nums) {
			if (visit[num])
				ans[idx++] = num;
			visit[num] = true;
		}

		return ans;
	}
}