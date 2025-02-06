package Medium.no1726;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int tupleSameProduct(int[] nums) {

		Arrays.sort(nums);
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i1 = 0; i1 < nums.length; i1++) {
			for (int i4 = i1 + 1; i4 < nums.length; i4++) {

				int prod = nums[i1] * nums[i4];
				ans += map.getOrDefault(prod, 0);
				map.put(prod, map.getOrDefault(prod, 0) + 1);
			}
		}

		return ans * 8;
	}
}