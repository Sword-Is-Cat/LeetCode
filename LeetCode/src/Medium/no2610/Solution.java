package Medium.no2610;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> findMatrix(int[] nums) {

		int[] counter = new int[201];

		int rows = 0;

		for (int num : nums) {
			rows = Math.max(rows, ++counter[num]);
		}

		List<List<Integer>> list = new ArrayList<>();

		while (rows-- > 0) {
			list.add(new ArrayList<>());
		}

		for (int num = 0; num < counter.length; num++) {
			for (int row = 0; row < counter[num]; row++) {
				list.get(row).add(num);
			}
		}

		return list;

	}
}
