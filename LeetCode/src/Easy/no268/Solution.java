package Easy.no268;

class Solution {
	public int missingNumber(int[] nums) {
		int num = nums.length;
		for (int i = 0; i < nums.length; i++) {
			num ^= i ^ nums[i];
		}
		return num;
	}
}