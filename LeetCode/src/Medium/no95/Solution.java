package Medium.no95;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<TreeNode>[][] cache;

	public List<TreeNode> generateTrees(int n) {
		cache = new List[n + 1][n + 1];
		return generateTree(1, n);
	}

	List<TreeNode> generateTree(int min, int max) {

		if (min >= 0 && min < cache.length && max >= 0 && max < cache.length && cache[min][max] != null)
			return cache[min][max];

		List<TreeNode> list = new ArrayList<>();

		if (min > max) {
			list.add(null);
		} else {

			for (int val = min; val <= max; val++) {

				List<TreeNode> lList = generateTree(min, val - 1);
				List<TreeNode> rList = generateTree(val + 1, max);

				for (TreeNode left : lList) {
					for (TreeNode right : rList) {
						list.add(new TreeNode(val, left, right));
					}
				}
			}
		}

		if (list.size() > 1)
			cache[min][max] = list;

		return list;
	}
}