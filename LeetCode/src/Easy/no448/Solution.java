package Easy.no448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> list = new ArrayList<>();

		Arrays.sort(nums);

		int index = 0;
		int no = 1;

		while (index < nums.length) {

			if (nums[index] == no) {
				index++;
				no++;
			} else if (nums[index] > no) {
				list.add(no);
				no++;
			} else
				index++;
		}

		if (no <= nums.length) {
			for (int i = no; i <= nums.length; i++)
				list.add(i);
		}
		return list;

	}
}