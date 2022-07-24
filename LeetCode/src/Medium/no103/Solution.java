package Medium.no103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();

		recursive(list, root, 0);

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 1)
				Collections.reverse(list.get(i));
		}

		return list;
	}

	void recursive(List<List<Integer>> list, TreeNode node, int depth) {

		if (node != null) {

			if (list.size() == depth)
				list.add(new ArrayList<>());

			list.get(depth).add(node.val);

			recursive(list, node.left, depth + 1);
			recursive(list, node.right, depth + 1);
		}
	}
}