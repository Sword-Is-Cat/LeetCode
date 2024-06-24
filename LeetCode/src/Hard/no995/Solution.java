package Hard.no995;

class Solution {
	public int minKBitFlips(int[] nums, int k) {

		int ans = 0, flip = 0;

		for (int i = 0; i < nums.length; i++) {

			if (k <= i && nums[i - k] == -1) {
				flip ^= 1;
			}

			if (nums[i] == flip) {
				if (i + k > nums.length) {
					return -1;
				}
				flip ^= 1;
				ans++;
				nums[i] = -1;
			}

		}
		return ans;
	}
}
