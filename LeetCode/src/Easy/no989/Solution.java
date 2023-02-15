package Easy.no989;

import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<Integer> addToArrayForm(int[] num, int k) {

		LinkedList<Integer> ans = new LinkedList<>();

		int pick = 0, val = 0, idx = num.length;

		while (idx-- > 0 || k > 0 || pick > 0) {
			val = k % 10 + pick + (idx < 0 ? 0 : num[idx]);
			ans.addFirst(val % 10);
			pick = val / 10;
			k /= 10;
		}

		return ans;

	}
}