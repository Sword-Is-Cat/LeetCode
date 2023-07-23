package Medium.no894;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	HashMap<Integer, List<TreeNode>> cache = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int n) {

		if (cache.containsKey(n))
			return cache.get(n);

		List<TreeNode> list = new ArrayList<>();

		if (n == 1) {
			list.add(new TreeNode());
		} else {
			for (int cnt = 1; cnt < n; cnt += 2) {
				for (TreeNode left : allPossibleFBT(cnt)) {
					for (TreeNode right : allPossibleFBT(n - 1 - cnt)) {
						TreeNode node = new TreeNode();
						node.left = left;
						node.right = right;
						list.add(node);
					}
				}
			}
		}

		cache.put(n, list);
		return list;
	}
}