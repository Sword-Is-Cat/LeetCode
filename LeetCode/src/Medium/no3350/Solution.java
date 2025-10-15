package Medium.no3350;

import java.util.List;

class Solution {

	public int maxIncreasingSubarrays(List<Integer> nums) {

		int left = 1, right = nums.size();
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (hasIncreasingSubarrays(nums, mid))
				left = mid;
			else
				right = mid;
		}

		return left;
	}

	public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

		int[] inc = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			if (i > 0 && nums.get(i - 1) < nums.get(i))
				inc[i] = inc[i - 1] + 1;
			else
				inc[i] = 1;
		}

		for (int i = 0; i < inc.length; i++)
			if (i >= k && inc[i] >= k && inc[i - k] >= k)
				return true;

		return false;
	}
}