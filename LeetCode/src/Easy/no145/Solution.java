package Easy.no145;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();
		postorderTraversal(list, root);
		return list;

	}

	public void postorderTraversal(List<Integer> list, TreeNode node) {

		if (node == null)
			return;

		postorderTraversal(list, node.left);
		postorderTraversal(list, node.right);
		list.add(node.val);

	}
}