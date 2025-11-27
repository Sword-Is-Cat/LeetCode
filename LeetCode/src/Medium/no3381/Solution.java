package Medium.no3381;

class Solution {
	public long maxSubarraySum(int[] nums, int k) {
		long[] sum = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		long ans = Long.MIN_VALUE, prev = 0, curr = 0;
		for (int i = 0; i < k; i++) {
			prev = 0;
			for (int j = i; j + k < sum.length; j += k) {
				prev = Math.max(prev, 0);
				curr = sum[j + k] - sum[j] + prev;
				ans = Math.max(ans, curr);
				prev = curr;
			}
		}
		return ans;
	}
}