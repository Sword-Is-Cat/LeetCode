package Easy.no3379;

class Solution {
	public int[] constructTransformedArray(int[] nums) {
		int length = nums.length;
		int[] rst = new int[length];

		for (int i = 0; i < length; i++) {
			rst[i] = nums[(100 * length + i + nums[i]) % length];
		}
		return rst;
	}
}