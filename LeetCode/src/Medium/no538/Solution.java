package Medium.no538;

class Solution {
	public TreeNode convertBST(TreeNode root) {

		if (root != null)
			convertNode(root, 0);

		return root;
	}

	int convertNode(TreeNode node, int sum) {

		if (node.right != null)
			sum = convertNode(node.right, sum);

		node.val += sum;
		sum = node.val;

		if (node.left != null)
			sum = convertNode(node.left, sum);

		return sum;
	}
}

