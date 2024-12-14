package Medium.no2762;

import java.util.TreeMap;

class Solution {
	public long continuousSubarrays(int[] nums) {

		long ans = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();

		int left = 0, right = 0;
		while (left < nums.length) {

			while (right < nums.length && (map.size() == 0
					|| (map.lowerKey(Integer.MAX_VALUE) - nums[right] < 3 && nums[right] - map.higherKey(0) < 3))) {
				map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
				right++;
			}

			map.put(nums[left], map.get(nums[left]) - 1);
			if (map.get(nums[left]) == 0)
				map.remove(nums[left], 0);
			ans += right - left;
			left++;

		}

		return ans;
	}
}