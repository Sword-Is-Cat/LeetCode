package Hard.no713;

class Solution {
	public int numSubarrayProductLessThanK(int[] nums, int k) {

		int prod = 1, cnt = 0;
		int left = 0, right = 0;

		while (left < nums.length) {

			if (left == right) {
				prod *= nums[right++];
			} else if (prod < k) {
				if (right < nums.length) {
					prod *= nums[right++];
				} else {
					cnt += right - left;
					prod /= nums[left++];
				}
			} else {
				prod /= nums[left++];
				cnt += right - left;
			}
		}
		return cnt;
	}
}