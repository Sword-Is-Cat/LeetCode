package Easy.no2200;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

		List<Integer> result = new ArrayList<>();

		int s = 0, e = 0, length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == key) {
				s = Math.max(e, i - k);
				e = Math.min(length, i + k + 1);
				for (int j = s; j < e; j++)
					result.add(j);
			}
		}

		return result;
	}
}