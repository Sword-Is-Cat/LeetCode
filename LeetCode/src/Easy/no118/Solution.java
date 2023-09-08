package Easy.no118;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> curr = null, prev = null;

		for (int row = 0; row < numRows; row++) {
			curr = new ArrayList<>();
			for (int col = 0; col <= row; col++) {
				if (col == 0 || col == row) {
					curr.add(1);
				} else {
					curr.add(prev.get(col - 1) + prev.get(col));
				}
			}
			prev = curr;
			ans.add(curr);
		}

		return ans;
	}
}