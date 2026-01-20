package Easy.no3314;

import java.util.HashMap;
import java.util.List;

class Solution {
	public int[] minBitwiseArray(List<Integer> nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= 1000; i++) {
			int rst = i | (i + 1);
			map.putIfAbsent(rst, i);
		}
		int[] ans = new int[nums.size()];
		for (int i = 0; i < ans.length; i++) {
			int key = nums.get(i);
			ans[i] = map.getOrDefault(key, -1);
		}
		return ans;
	}
}
