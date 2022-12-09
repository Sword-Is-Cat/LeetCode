package Medium.no1026;

class Solution {

	public int maxAncestorDiff(TreeNode root) {
		return dfs(root, root.val, root.val);
	}

	int dfs(TreeNode node, int max, int min) {

		if (node == null)
			return 0;

		int rst = Math.max(max - node.val, node.val - min);

		if (node.val > max)
			max = node.val;

		if (node.val < min)
			min = node.val;

		rst = Math.max(rst, dfs(node.left, max, min));
		rst = Math.max(rst, dfs(node.right, max, min));

		return rst;
	}
}