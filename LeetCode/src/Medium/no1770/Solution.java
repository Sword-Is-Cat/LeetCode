package Medium.no1770;

class Solution {

	Integer[][] cache;

	public int maximumScore(int[] nums, int[] multipliers) {

		cache = new Integer[nums.length][multipliers.length];

		return process(0, nums.length - 1, 0, nums, multipliers);
	}

	int process(int left, int right, int idx, int[] nums, int[] multi) {

		if (idx >= multi.length)
			return 0;

		if (cache[left][idx] == null) {

			int rstL = process(left + 1, right, idx + 1, nums, multi) + nums[left] * multi[idx];
			int rstR = process(left, right - 1, idx + 1, nums, multi) + nums[right] * multi[idx];

			cache[left][idx] = Math.max(rstL, rstR);

		}
		return cache[left][idx];

	}

}