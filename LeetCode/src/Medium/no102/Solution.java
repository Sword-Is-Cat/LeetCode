package Medium.no102;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<List<Integer>> list;

	public List<List<Integer>> levelOrder(TreeNode root) {

		list = new ArrayList<>();

		process(root, 0);

		return list;
	}

	void process(TreeNode node, int depth) {

		if (node == null)
			return;

		if (list.size() == depth)
			list.add(new ArrayList<>());

		list.get(depth).add(node.val);

		process(node.left, depth + 1);
		process(node.right, depth + 1);

	}
}
