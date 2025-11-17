package Easy.no1437;

class Solution {
	public boolean kLengthApart(int[] nums, int k) {
		int dist = k;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (dist < k) {
					return false;
				}
				dist = 0;
			} else {
				dist++;
			}
		}
		return true;
	}
}