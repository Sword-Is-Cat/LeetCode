package Challenge.September3rd_2;

class Solution {
	public int findMaximumXOR(int[] nums) {

		if (nums.length == 1)
			return 0;

		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length - 1; i++)
			for (int j = i + 1; j < nums.length; j++)
				answer = Math.max(answer, nums[i] ^ nums[j]);

		return answer;
	}
}