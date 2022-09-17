package Medium.no260;

import java.util.HashSet;

class Solution {
	public int[] singleNumber(int[] nums) {

		int[] ans = new int[2];
		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			if (!set.add(num))
				set.remove(num);
		}

		int idx = 0;
		for (int no : set)
			ans[idx++] = no;

		return ans;
	}
}