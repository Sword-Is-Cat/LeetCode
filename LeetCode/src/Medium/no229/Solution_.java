package Medium.no229;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class Solution_ {
	public List<Integer> majorityElement(int[] nums) {

		HashSet<Integer> set = new HashSet<>();
		int size = nums.length / 3;

		Arrays.sort(nums);

		for (int i = 0; i + size < nums.length; i++) {

			if (nums[i] == nums[i + size])
				set.add(nums[i]);

		}

		return set.stream().collect(Collectors.toList());

	}
}