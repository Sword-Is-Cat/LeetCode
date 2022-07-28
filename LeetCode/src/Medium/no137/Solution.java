package Medium.no137;

import java.util.HashSet;

class Solution {
	public int singleNumber(int[] nums) {

		HashSet<Integer> single = new HashSet<>();
		HashSet<Integer> dupl = new HashSet<>();

		for (int no : nums) {

			if (!single.add(no))
				dupl.add(no);

		}

		single.removeAll(dupl);

		return single.iterator().next();
	}
}