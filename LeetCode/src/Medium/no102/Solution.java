package Medium.no102;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {

		return process(new ArrayList<>(), root, 0);

	}

	List<List<Integer>> process(List<List<Integer>> list, TreeNode node, int depth) {

		if (node != null) {

			if (list.size() == depth)
				list.add(new ArrayList<>());

			list.get(depth).add(node.val);

			process(list, node.left, depth + 1);
			process(list, node.right, depth + 1);
		}

		return list;
	}
}
