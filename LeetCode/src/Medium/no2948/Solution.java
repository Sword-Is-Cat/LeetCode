package Medium.no2948;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] lexicographicallySmallestArray(int[] nums, int limit) {

		int[] sorted = nums.clone();
		Arrays.sort(sorted);

		Map<Integer, Integer> numGroup = new HashMap<>();
		List<Integer> indexes = new ArrayList<>();
		int groupNo = 0;

		numGroup.put(sorted[0], groupNo);
		indexes.add(0);

		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i] - sorted[i - 1] > limit) {
				indexes.add(i);
				groupNo++;
			}
			numGroup.put(sorted[i], groupNo);
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sorted[indexes.get(numGroup.get(nums[i]))];
			indexes.set(numGroup.get(nums[i]), indexes.get(numGroup.get(nums[i])) + 1);
		}

		return nums;
	}
}