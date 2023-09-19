package Medium.no287;

import java.util.HashSet;
import java.util.Set;

class Solution_ {
	public int findDuplicate(int[] nums) {

		Set<Integer> set = new HashSet<>();

		int rst = -1;

		for (int no : nums) {
			if (!set.add(no)) {
				rst = no;
				break;
			}
		}
		return rst;
	}
}