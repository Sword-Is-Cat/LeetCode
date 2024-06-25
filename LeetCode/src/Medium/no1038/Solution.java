package Medium.no1038;

class Solution {
	public TreeNode bstToGst(TreeNode root) {

		addNumGetSum(root, 0);

		return root;
	}

	private int addNumGetSum(TreeNode node, int add) {

		if (node == null)
			return add;

		node.val += addNumGetSum(node.right, add);

		return addNumGetSum(node.left, node.val);
	}
}