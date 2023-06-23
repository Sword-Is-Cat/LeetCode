package Medium.no1027;

class Solution {
	public int longestArithSeqLength(int[] nums) {

		int ans = 2;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				ans = Math.max(ans, calcSeqLength(nums, i, j));
			}
		}

		return ans;
	}

	private int calcSeqLength(int[] nums, int i, int j) {

		int diff = nums[j] - nums[i], length = 2;

		for (int idx = j + 1, target = nums[j] + diff; idx < nums.length; idx++) {

			if (nums[idx] == target) {
				length++;
				target += diff;
			}

		}

		return length;
	}
}