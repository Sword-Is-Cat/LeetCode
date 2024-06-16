package Hard.no330;

class Solution {
	public int minPatches(int[] nums, int n) {

		long sum = 0;
		int ans = 0, idx = 0;

		while (sum < n) {
			if (idx == nums.length || sum + 1 < nums[idx]) {
				sum += sum + 1;
				ans++;
			} else {
				sum += nums[idx++];
			}
		}

		return ans;
	}
}