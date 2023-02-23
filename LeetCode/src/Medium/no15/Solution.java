package Medium.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (0 < i && nums[i - 1] == nums[i])
				continue;
			for (int j = i + 1; j < nums.length; j++) {
				if (i + 1 < j && nums[j - 1] == nums[j])
					continue;

				int head = j + 1, tail = nums.length, target = 0 - nums[i] - nums[j];

				while (head + 1 < tail) {
					int mid = (head + tail) / 2;
					if (nums[mid] <= target)
						head = mid;
					else
						tail = mid;
				}
				if (head < nums.length && nums[i] + nums[j] + nums[head] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[head]);
					ans.add(list);
				}
			}
		}
		return ans;
	}
}