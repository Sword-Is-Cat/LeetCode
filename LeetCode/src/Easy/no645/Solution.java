package Easy.no645;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] findErrorNums(int[] nums) {

		int[] answer = new int[2];

		Set<Integer> set = new HashSet<>();

		for (int i : nums)
			if (!set.add(i))
				answer[0] = i;

		for (int i = 1; i <= nums.length; i++)
			if (set.add(i))
				answer[1] = i;

		return answer;

	}
}