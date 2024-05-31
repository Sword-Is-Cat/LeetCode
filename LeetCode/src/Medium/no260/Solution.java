package Medium.no260;

class Solution {
	public int[] singleNumber(int[] nums) {

		int[] ans = new int[2];
		int temp = 0;
		for (int num : nums) {
			temp ^= num;
		}

		temp &= -temp;

		for (int num : nums) {
			if ((temp & num) == 0) {
				ans[0] ^= num;
			} else {
				ans[1] ^= num;
			}
		}

		return ans;
	}
}