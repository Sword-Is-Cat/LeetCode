package Medium.no2270;

class Solution {
	public int waysToSplitArray(int[] nums) {

		long sum = 0L, temp = 0L;
		int ans = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		for (int i = 0; i < nums.length - 1; i++) {
			temp += nums[i] * 2;
			if (temp >= sum)
				ans++;
		}

		return ans;
	}
}