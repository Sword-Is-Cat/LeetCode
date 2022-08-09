package Medium.no814;

class Solution {
	public TreeNode pruneTree(TreeNode root) {

		if (root == null)
			return null;

		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);

		if (root.left == null && root.right == null)
			if (root.val != 1)
				return null;

		return root;

	}
}