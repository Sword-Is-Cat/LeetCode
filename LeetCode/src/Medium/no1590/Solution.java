package Medium.no1590;

import java.util.HashMap;

class Solution {
	public int minSubarray(int[] nums, int p) {

		int[] preSum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			preSum[i + 1] = (preSum[i] + nums[i]) % p;
		}

		int sum = preSum[nums.length];
		if (sum == 0)
			return 0;

		int min = nums.length;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < preSum.length; i++) {
			if (map.containsKey(preSum[i])) {
				min = Math.min(min, i - map.get(preSum[i]));
			}
			map.put((sum + preSum[i]) % p, i);
		}

		return min == nums.length ? -1 : min;
	}
}