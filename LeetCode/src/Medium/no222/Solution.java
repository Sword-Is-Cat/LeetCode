package Medium.no222;

class Solution {

	int cnt = 0;

	public int countNodes(TreeNode root) {
		dfs(root);
		return cnt;
	}

	void dfs(TreeNode node) {
		if (node == null)
			return;

		cnt++;

		dfs(node.left);
		dfs(node.right);

	}

}