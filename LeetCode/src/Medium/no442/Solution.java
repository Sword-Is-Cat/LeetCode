package Medium.no442;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> answer = new ArrayList<>();
		boolean[] visit = new boolean[nums.length + 1];

		for (int num : nums) {
			if (visit[num]) {
				answer.add(num);
			}
			visit[num] = true;
		}

		return answer;
	}
}