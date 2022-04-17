package Easy.no897;

class Solution {

	public TreeNode increasingBST(TreeNode root) {

		if (root != null) {

			if (root.left != null) {

				TreeNode left = root.left;
				getRightEnd(left).right = root;
				root.left = null;
				return increasingBST(left);

			} else if (root.right != null) {
				root.right = increasingBST(root.right);
			}
		}
		return root;
	}

	TreeNode getRightEnd(TreeNode node) {
		if (node != null && node.right != null)
			return getRightEnd(node.right);
		return node;
	}
}