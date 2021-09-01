package Easy.no228;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> summaryRanges(int[] nums) {

		List<String> list = new ArrayList<>();

		if (nums.length > 0) {

			int val = nums[0];
			int lastVal = val;
			StringBuilder sb = new StringBuilder();
			sb.append(val);
			String arrow = "->";

			for (int i = 1; i < nums.length; i++) {

				if (val + 1 != nums[i]) {

					if (lastVal != val) {
						sb.append(arrow);
						sb.append(val);
					}

					list.add(sb.toString());
					sb = new StringBuilder();

					lastVal = nums[i];
					sb.append(lastVal);

				}

				val = nums[i];

			}

			if (lastVal != val) {
				sb.append(arrow);
				sb.append(val);
			}

			list.add(sb.toString());

		}

		return list;

	}
}