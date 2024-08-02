package Medium.no2134;

class Solution {
	public int minSwaps(int[] nums) {

		int cntAllOne = 0, i = 0, cnt = 0;

		for (i = 0; i < nums.length; i++) {
			cntAllOne += nums[i];
		}

		for (i = 0; i < cntAllOne; i++) {
			cnt += nums[i];
		}

		int max = cnt;

		for (int d = 0; d < nums.length; d++) {
			cnt += nums[(i + d) % nums.length] - nums[(i + d - cntAllOne) % nums.length];
			max = Math.max(max, cnt);
		}

		return cntAllOne - max;
	}
}