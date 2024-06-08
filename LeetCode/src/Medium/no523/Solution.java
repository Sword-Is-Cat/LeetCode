package Medium.no523;

import java.util.HashMap;

class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {

		int remainder = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(remainder, -1);

		for (int i = 0; i < nums.length; i++) {
			remainder = (remainder + nums[i]) % k;
			if (map.containsKey(remainder)) {
				if (i - map.get(remainder) > 1) {
					return true;
				}
			} else {
				map.put(remainder, i);
			}
		}

		return false;

	}
}