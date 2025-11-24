package Easy.no1018;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Boolean> prefixesDivBy5(int[] nums) {
		
		int acc = 0;
		List<Boolean> ans = new ArrayList<>();

		for (int num : nums) {
			acc = (acc * 2 + num) % 5;
			ans.add(acc == 0);
		}

		return ans;
	}
}