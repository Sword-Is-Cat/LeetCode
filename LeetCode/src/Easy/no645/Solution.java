package Easy.no645;

class Solution {
	public int[] findErrorNums(int[] nums) {

		int n = nums.length;
		int origin = 0;
		int[] ans = new int[2];
		boolean[] visit = new boolean[n + 1];

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (visit[val]) {
				ans[0] = val;
			} else {
				visit[val] = true;
				origin ^= val;
			}
			origin ^= (i + 1);
		}
		ans[1] = origin;
		return ans;

	}
}