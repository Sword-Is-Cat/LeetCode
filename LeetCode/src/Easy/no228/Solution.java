package Easy.no228;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> summaryRanges(int[] nums) {

		ArrayList<String> list = new ArrayList<>();

		if (nums.length > 0) {

			int start = nums[0], end = nums[0] - 1;

			for (int i = 0; i < nums.length; i++) {

				int num = nums[i];

				if (end + 1 != num) {
					list.add(stringify(start, end));
					start = num;
				}

				end = num;

				if (i == nums.length - 1) {
					list.add(stringify(start, end));
				}

			}
		}

		return list;
	}

	private String stringify(int a, int b) {

		if (a == b) {
			return Integer.toString(a);
		} else {
			return "{0}->{1}".replace("{0}", Integer.toString(a)).replace("{1}", Integer.toString(b));
		}

	}

}