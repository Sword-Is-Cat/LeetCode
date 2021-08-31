package Easy.no144;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if (root != null) {
			addValToList(list, root);
		}
		return list;

	}

	public void addValToList(List<Integer> list, TreeNode node) {

		list.add(node.val);

		if (node.left != null)
			addValToList(list, node.left);

		if (node.right != null)
			addValToList(list, node.right);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}