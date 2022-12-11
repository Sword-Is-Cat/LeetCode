package Hard.no124;

class Solution {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		dfs(root);

		return max;
	}

	int dfs(TreeNode node) {

		if (node == null)
			return 0;

		int val = node.val;

		int left = dfs(node.left), right = dfs(node.right);

		max = Math.max(max, val + left + right);
		val += Math.max(left, right);

		return Math.max(val, 0);
	}

}