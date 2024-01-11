package Medium.no1026;

class Solution {

	public int maxAncestorDiff(TreeNode root) {
		return dfs(root, root.val, root.val);
	}

	private int dfs(TreeNode node, int max, int min) {

		if (node == null)
			return max - min;

		max = Math.max(max, node.val);
		min = Math.min(min, node.val);

		int result = max - min;

		result = Math.max(result, Math.max(dfs(node.left, max, min), dfs(node.right, max, min)));

		return result;
	}
}