package Medium.no1457;

class Solution {

	public int pseudoPalindromicPaths(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode node, int mask) {

		if (node == null)
			return 0;

		int result = 0;
		mask ^= 1 << node.val;

		if (node.left == null && node.right == null) {
			if (mask == 0) {
				result = 1;
			} else {
				for (int i = 1; i < 10; i++) {
					if ((mask ^ (1 << i)) == 0) {
						result = 1;
						break;
					}
				}
			}
		} else {
			result = dfs(node.left, mask) + dfs(node.right, mask);
		}

		mask ^= 1 << node.val;

		return result;
	}
}