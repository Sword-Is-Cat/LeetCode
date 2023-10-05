package Medium.no229;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> majorityElement(int[] nums) {

		int value1 = Integer.MAX_VALUE, cnt1 = 0, value2 = Integer.MAX_VALUE, cnt2 = 0;

		for (int num : nums) {
			if (num == value1) {
				cnt1++;
			} else if (num == value2) {
				cnt2++;
			} else if (cnt1 == 0) {
				value1 = num;
				cnt1 = 1;
			} else if (cnt2 == 0) {
				value2 = num;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = cnt2 = 0;

		for (int num : nums) {
			if (num == value1)
				cnt1++;
			else if (num == value2)
				cnt2++;
		}

		List<Integer> list = new ArrayList<>();

		if (cnt1 > nums.length / 3)
			list.add(value1);
		if (cnt2 > nums.length / 3)
			list.add(value2);

		return list;
	}
}