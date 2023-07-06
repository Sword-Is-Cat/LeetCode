package Medium.no209;

class Solution_ {
	public int minSubArrayLen(int target, int[] nums) {

		int left = 0, right = 0, sum = 0, ans = 0;

		while (right < nums.length) {

			if (sum < target) {
				sum += nums[right++];
			} else {
				if (ans == 0)
					ans = right - left;
				else
					ans = Math.min(ans, right - left);

				sum -= nums[left++];
			}

		}

		while (sum >= target) {

			if (ans == 0)
				ans = right - left;
			else
				ans = Math.min(ans, right - left);

			sum -= nums[left++];
		}

		return ans;
	}
}