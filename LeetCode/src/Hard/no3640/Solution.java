package Hard.no3640;

class Solution {
	public long maxSumTrionic(int[] nums) {

		int[] isLowHigh = new int[nums.length];
		long[] sums = new long[nums.length];

		int flag = 0;
		long sum = 0;
		for (int i = 1; i < nums.length; i++) {
			if (i < nums.length - 1 && nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) {
				flag = i;
				isLowHigh[i] = -1;
				sum = 0;
				sums[i] = nums[i + 1];
			} else if (nums[i - 1] < nums[i]) {
				sum += nums[i];
				if (flag != 0) {
					sums[flag] = Math.max(sums[flag], sum);
				}
			} else {
				flag = 0;
				sum = 0;
			}
		}

		flag = 0;
		sum = 0;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (i > 0 && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				flag = i;
				isLowHigh[i] = 1;
				sum = 0;
				sums[i] = nums[i - 1];
			} else if (nums[i] < nums[i + 1]) {
				sum += nums[i];
				if (flag != 0) {
					sums[flag] = Math.max(sums[flag], sum);
				}
			} else {
				flag = 0;
				sum = 0;
			}
		}

		long ans = Long.MIN_VALUE;
		sum = 0;
		boolean visitHigh = false;

		for (int i = 1; i < nums.length - 1; i++) {
			if (isLowHigh[i] == 1) {
				sum = sums[i];
				visitHigh = true;
			}
			sum += nums[i];
			if (isLowHigh[i] == -1) {
				sum += sums[i];
				if (visitHigh) {
					ans = Math.max(ans, sum);
				}
			}
		}

		return ans;
	}
}