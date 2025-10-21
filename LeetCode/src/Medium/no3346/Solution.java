package Medium.no3346;

class Solution {
	public int maxFrequency(int[] nums, int k, int numOperations) {

		int min = nums[0], max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		int[] accCnt = new int[max + 1];
		for (int num : nums)
			accCnt[num]++;

		for (int i = 1; i <= max; i++)
			accCnt[i] += accCnt[i - 1];

		int ans = 0;

		for (int target = min; target <= max; target++)
			ans = Math.max(ans, getAmount(accCnt, target, k, numOperations));

		return ans;
	}

	public int getAmount(int[] cnt, int target, int k, int oper) {
		int eq = getCount(cnt, target, target);
		int avail = getCount(cnt, target - k, target + k) - eq;
		return eq + Math.min(avail, oper);
	}

	public int getCount(int[] cnt, int from, int to) {
		return cnt[Math.min(cnt.length - 1, to)] - cnt[Math.max(from - 1, 0)];
	}

}