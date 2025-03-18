package Medium.no2401;

class Solution {
	public int longestNiceSubarray(int[] nums) {

		int rmvIdx = 0, mask = 0, answer = 0;

		for (int addIdx = 0; addIdx < nums.length; addIdx++) {
			while ((mask & nums[addIdx]) != 0) {
				mask ^= nums[rmvIdx++];
			}
			mask ^= nums[addIdx];
			answer = Math.max(answer, addIdx - rmvIdx);
		}

		return answer + 1;
	}
}