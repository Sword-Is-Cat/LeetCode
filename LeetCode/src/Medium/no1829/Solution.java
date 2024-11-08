package Medium.no1829;

class Solution {
	public int[] getMaximumXor(int[] nums, int maximumBit) {
		int[] answer = new int[nums.length];
		int temp = (1 << maximumBit) - 1;
		for (int i = 0; i < nums.length; i++) {
			temp ^= nums[i];
			answer[nums.length - 1 - i] = temp;
		}
		return answer;
	}
}