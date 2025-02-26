package Medium.no1749;

class Solution {
	public int maxAbsoluteSum(int[] nums) {

		int ans = 0;
		int sum = 0;
		int minSum = 0, maxSum = 0;

		for (int num : nums) {

			sum += num;

			ans = Math.max(ans, Math.max(sum - minSum, maxSum - sum));

			minSum = Math.min(minSum, sum);
			maxSum = Math.max(maxSum, sum);

		}

		return ans;

	}
}