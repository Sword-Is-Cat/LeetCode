package Medium.no1372;

class Solution {

	public int longestZigZag(TreeNode root) {

		return Math.max(dfs(root.left, true, 0), dfs(root.right, false, 0));
	}

	private int dfs(TreeNode node, boolean isLeft, int dist) {

		if (node == null)
			return dist;

		if (isLeft) {
			return Math.max(dfs(node.right, !isLeft, dist + 1), dfs(node.left, isLeft, 0));
		} else {
			return Math.max(dfs(node.left, !isLeft, dist + 1), dfs(node.right, isLeft, 0));
		}

	}
}