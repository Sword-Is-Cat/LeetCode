package Medium.no2593;

class Solution {
	public long findScore(int[] nums) {

		long ans = 0L;

		for (int i = 0; i < nums.length; i += 2) {
			int temp = i;
			while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
				i++;
			}
			for (int j = i; j >= temp; j -= 2) {
				ans += nums[j];
			}
		}

		return ans;
	}
}