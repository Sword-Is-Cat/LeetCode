package Hard.no1793;

class Solution {
	public int maximumScore(int[] nums, int k) {

		int left = k, right = k;
		int min = nums[k], ans = nums[k];

		while (0 < left || right < nums.length - 1) {

			int leftVal = 0 < left ? nums[left - 1] : 0;
			int rightVal = right < nums.length - 1 ? nums[right + 1] : 0;

			if (leftVal < rightVal) {
				min = Math.min(min, nums[++right]);
			} else {
				min = Math.min(min, nums[--left]);
			}

			ans = Math.max(ans, min * (right - left + 1));

		}

		return ans;
	}
}