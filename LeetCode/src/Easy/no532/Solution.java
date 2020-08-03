package Easy.no532;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int findPairs(int[] nums, int k) {

		Arrays.sort(nums);
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] - nums[i] == k) {
					set.add(nums[i]+nums[j]);
					break;
				} else if (nums[j] - nums[i] > k)
					break;
			}
		}

		return set.size();

	}
}