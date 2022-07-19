package Easy.no118;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<>();

		while (numRows-- > 0)
			list.add(new ArrayList<>());

		for (int row = 0; row < list.size(); row++) {

			for (int col = 0; col <= row; col++) {
				
				int value = 0;

				if (col == 0 || col == row) {
					value = 1;
				} else {
					List<Integer> prevList = list.get(row - 1);
					value = prevList.get(col - 1) + prevList.get(col);
				}
				
				list.get(row).add(value);
			}
		}
		return list;
	}
}