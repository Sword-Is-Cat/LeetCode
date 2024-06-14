package Medium.no945;

class Solution {
	public int minIncrementForUnique(int[] nums) {

		int[] cnt = new int[100001];
		int ans = 0, hold = 0;

		for (int num : nums) {
			cnt[num]++;
		}

		for (int i = 0; i < cnt.length; i++) {
			ans += hold;
			hold += cnt[i];
			if (hold > 0) {
				hold--;
			}
		}
		if (hold > 0) {
			ans += hold * (hold + 1) / 2;
		}

		return ans;
	}
}