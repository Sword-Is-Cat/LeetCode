package Medium.no1814;

import java.util.Arrays;

class Solution {

	final int mod = (int) 1e9 + 7;

	public int countNicePairs(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			nums[i] -= rev(nums[i]);
		}

		Arrays.sort(nums);

		int last = nums[0] - 1, cnt = 0;
		int ans = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == last) {
				cnt++;
			} else {
				ans += pick2(cnt);
				ans %= mod;
				last = nums[i];
				cnt = 1;
			}
		}
		
		ans += pick2(cnt);
		ans %= mod;

		return ans;
	}

	private int rev(int num) {
		int result = 0;

		while (num > 0) {
			result *= 10;
			result += num % 10;
			num /= 10;
		}

		return result;
	}

	private int pick2(int amount) {
		return (int) ((1L * amount * (amount - 1) / 2) % mod);
	}
}