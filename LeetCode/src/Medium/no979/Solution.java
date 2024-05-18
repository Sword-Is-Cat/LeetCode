package Medium.no979;

class Solution {
	public int distributeCoins(TreeNode root) {
		if (root == null)
			return 0;
		int moveLeft = Math.abs(countNodes(root.left) - sumNodesVal(root.left));
		int moveRight = Math.abs(countNodes(root.right) - sumNodesVal(root.right));
		return distributeCoins(root.left) + distributeCoins(root.right) + moveLeft + moveRight;
	}

	private int countNodes(TreeNode node) {
		if (node == null)
			return 0;
		return countNodes(node.left) + countNodes(node.right) + 1;
	}

	private int sumNodesVal(TreeNode node) {
		if (node == null)
			return 0;
		return sumNodesVal(node.left) + sumNodesVal(node.right) + node.val;
	}
}