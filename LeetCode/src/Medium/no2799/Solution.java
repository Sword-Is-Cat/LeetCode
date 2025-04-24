package Medium.no2799;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int countCompleteSubarrays(int[] nums) {

		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			set.add(num);

		int fullSize = set.size(), answer = 0;

		int size = 0, addIdx = 0, rmvIdx = 0;

		while (rmvIdx < nums.length) {

			while (addIdx < nums.length && size < fullSize) {
				int addNum = nums[addIdx++];
				map.put(addNum, map.getOrDefault(addNum, 0) + 1);
				if (map.get(addNum) == 1)
					size++;
			}
			if (size == fullSize)
				answer += nums.length - addIdx + 1;

			int rmvNum = nums[rmvIdx++];
			map.put(rmvNum, map.get(rmvNum) - 1);
			if (map.get(rmvNum) == 0)
				size--;

		}

		return answer;

	}
}