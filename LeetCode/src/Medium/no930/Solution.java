package Medium.no930;

class Solution {
	public int numSubarraysWithSum(int[] nums, int goal) {

		return numSubarraysLTorEQwithSum(nums, goal) - numSubarraysLTorEQwithSum(nums, goal - 1);

	}

	public int numSubarraysLTorEQwithSum(int[] nums, int goal) {

		if (goal < 0)
			return 0;

		int i = 0, j = 0;
		int sum = 0, ans = 0;

		while (i < nums.length) {

			sum += nums[i];

			while (sum > goal && j < nums.length) {
				sum -= nums[j];
				j++;
			}

			if (sum <= goal) {
				ans += i - j + 1;
			}

			i++;
		}
		return ans;
	}
}