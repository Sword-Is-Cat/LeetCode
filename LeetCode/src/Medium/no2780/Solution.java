package Medium.no2780;

import java.util.List;

class Solution {
	public int minimumIndex(List<Integer> nums) {

		int length = nums.size(), dominantElement = nums.get(0), count = 0;

		for (int i = 0; i < length; i++) {
			int item = nums.get(i);
			if (item == dominantElement) {
				count++;
			} else if (count == 0) {
				dominantElement = item;
				count++;
			} else {
				count--;
			}
		}

		count = 0;

		for (int i = 0; i < length; i++) {
			if (nums.get(i) == dominantElement)
				count++;
		}

		if (count <= length - count + 1)
			return -1;

		count = 0;

		for (int i = 0; i < length; i++) {
			if (nums.get(i) == dominantElement) {
				count++;
			} else {
				count--;
			}
			if (count > 0)
				return i;
		}

		return -1;
	}
}