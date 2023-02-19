package Medium.no103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

	List<List<Integer>> list;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		list = new ArrayList<>();
		dfs(root, 0);
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 1)
				Collections.reverse(list.get(i));
		}

		return list;
	}

	void dfs(TreeNode node, int depth) {

		if (node != null) {
			if (list.size() == depth)
				list.add(new ArrayList<>());

			list.get(depth).add(node.val);

			dfs(node.left, depth + 1);
			dfs(node.right, depth + 1);
		}
	}
}