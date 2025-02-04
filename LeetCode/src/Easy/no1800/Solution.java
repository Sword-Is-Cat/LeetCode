package Easy.no1800;

class Solution {
	public int maxAscendingSum(int[] nums) {
		int ascendingSum = 0, maxAscendingSum = 0;
		int prev = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (prev < nums[i]) {
				ascendingSum += nums[i];
			} else {
				ascendingSum = nums[i];
			}
			maxAscendingSum = Math.max(maxAscendingSum, ascendingSum);
			prev = nums[i];
		}

		return maxAscendingSum;
	}
}