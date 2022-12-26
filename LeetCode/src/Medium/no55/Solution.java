package Medium.no55;

class Solution {
	public boolean canJump(int[] nums) {
		int reachable = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			if (reachable < idx)
				return false;
			reachable = Math.max(reachable, idx + nums[idx]);
		}
		return true;
	}
}