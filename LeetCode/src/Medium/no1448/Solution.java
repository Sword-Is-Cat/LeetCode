package Medium.no1448;

class Solution {
	public int goodNodes(TreeNode root) {
		return calcGoodNode(root, root.val);
	}

	int calcGoodNode(TreeNode node, int val) {

		if (node == null)
			return 0;

		int rst = node.val < val ? 0 : 1;

		val = Math.max(val, node.val);

		rst += calcGoodNode(node.left, val);
		rst += calcGoodNode(node.right, val);

		return rst;
	}
}