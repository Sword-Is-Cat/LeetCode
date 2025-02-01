package Easy.no3151;

class Solution {
	public boolean isArraySpecial(int[] nums) {

		boolean result = true;

		for (int i = 1; result && i < nums.length; i++) {
			result &= ((nums[i] ^ nums[i - 1]) & 1) == 1;
		}

		return result;
	}
}