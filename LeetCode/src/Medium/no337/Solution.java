package Medium.no337;

class Solution {
	public int rob(TreeNode root) {

		int[] rst = dfs(root);

		return Math.max(rst[0], rst[1]);
	}

	private int[] dfs(TreeNode node) {

		if (node == null)
			return new int[] { 0, 0 };

		int[] result = { node.val, 0 };
		int[] leftR = dfs(node.left), rightR = dfs(node.right);
		result[0] += leftR[1] + rightR[1];
		result[1] += Math.max(leftR[0], leftR[1]) + Math.max(rightR[0], rightR[1]);

		return result;
	}
}