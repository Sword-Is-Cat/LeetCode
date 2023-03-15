package Medium.no958;

class Solution {

	int cnt = 0, max = 0;

	public boolean isCompleteTree(TreeNode root) {
		dfs(root, 0);
		return cnt - max == 1;
	}

	protected void dfs(TreeNode node, int num) {
		if (node == null)
			return;
		cnt++;
		max = Math.max(max, num);
		dfs(node.left, num * 2 + 1);
		dfs(node.right, num * 2 + 2);
	}
}