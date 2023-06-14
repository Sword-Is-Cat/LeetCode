package Easy.no530;

class Solution {

	int ans = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {

		dfs(root);

		return ans;
	}

	private void dfs(TreeNode node) {

		if (node == null)
			return;

		if (node.left != null)
			ans = Math.min(ans, node.val - getMaxValue(node.left));

		if (node.right != null)
			ans = Math.min(ans, getMinValue(node.right) - node.val);

		dfs(node.left);
		dfs(node.right);

	}

	private int getMinValue(TreeNode node) {
		return node.left == null ? node.val : getMinValue(node.left);
	}

	private int getMaxValue(TreeNode node) {
		return node.right == null ? node.val : getMaxValue(node.right);
	}

}