package Easy.no1752;

class Solution {
	public boolean check(int[] nums) {
		int prev = nums[0], cnt = 0, loop = 2;
		while (loop-- > 0) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] < prev) {
					cnt = 1;
				} else {
					if (++cnt == nums.length) {
						return true;
					}
				}
				prev = nums[i];
			}
		}
		return false;
	}
}