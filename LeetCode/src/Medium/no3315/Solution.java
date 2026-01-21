package Medium.no3315;

import java.util.List;

class Solution {
	public int[] minBitwiseArray(List<Integer> nums) {

		int[] ans = new int[nums.size()];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = convert(nums.get(i));
		}

		return ans;
	}

	private int convert(int num) {
		if (num == 2)
			return -1;
		int cnt = 0;
		while (num % 2 == 1) {
			cnt++;
			num /= 2;
		}
		num *= 2;
		cnt--;
		while (cnt > 0) {
			cnt--;
			num *= 2;
			num++;
		}
		return num;
	}
}