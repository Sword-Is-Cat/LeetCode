package Medium.no1441;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> buildArray(int[] target, int n) {

		List<String> ans = new ArrayList<>();
		int last = 0;

		for (int num : target) {

			int loop = num - last - 1;
			last = num;

			while (loop-- > 0) {
				ans.add("Push");
				ans.add("Pop");
			}
			ans.add("Push");
		}
		return ans;
	}
}