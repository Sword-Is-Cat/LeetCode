package Easy.no2441;

class Solution {
	public int findMaxK(int[] nums) {

		boolean[] flags = new boolean[1001];
		for (int num : nums) {
			if (num < 0) {
				flags[-num] = true;
			}
		}

		int ans = -1;

		for (int num : nums) {
			if (num > 0 && flags[num]) {
				ans = Math.max(ans, num);
			}
		}
		return ans;

	}
}