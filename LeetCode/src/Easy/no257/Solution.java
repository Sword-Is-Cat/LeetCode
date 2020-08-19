package Easy.no257;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<String> list;

	public List<String> binaryTreePaths(TreeNode root) {

		list = new ArrayList<>();
		
		if (root == null)
			return list;

		StringBuilder sb = new StringBuilder();

		process(root, sb);

		return list;

	}

	void process(TreeNode node, StringBuilder sb) {

		sb.append(node.val);

		if (node.left == null && node.right == null)
			list.add(sb.toString());
		else {

			sb.append("->");

			if (node.left != null)
				process(node.left, new StringBuilder(sb));

			if (node.right != null) {
				process(node.right, new StringBuilder(sb));
			}
		}
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