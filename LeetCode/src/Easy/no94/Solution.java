package Easy.no94;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if (root != null) {
			addValToList(list, root);
		}
		return list;

	}

	public void addValToList(List<Integer> list, TreeNode node) {

		if (node.left != null)
			addValToList(list, node.left);

		list.add(node.val);
		
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