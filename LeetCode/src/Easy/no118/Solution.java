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

				if (col == 0 || col == row)
					list.get(row).add(1);
				else
					list.get(row).add(list.get(row - 1).get(col - 1) + list.get(row - 1).get(col));
			}
		}
		return list;
	}
}