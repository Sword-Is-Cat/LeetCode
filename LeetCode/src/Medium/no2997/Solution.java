package Medium.no2997;

class Solution {
	public int minOperations(int[] nums, int k) {

		for (int num : nums) {
			k ^= num;
		}

		int ans = 0;

		while (k > 0) {
			ans += k & 1;
			k >>= 1;
		}

		return ans;
	}
}