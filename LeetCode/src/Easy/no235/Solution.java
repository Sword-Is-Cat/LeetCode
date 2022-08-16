package Easy.no235;

class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		TreeNode result = null;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null && right == null) {

			if (root == p || root == q)
				result = root;

		} else if (left != null && right != null) {

			result = root;

		} else {

			result = left == null ? right : left;

			if (root == p || root == q)
				result = root;
		}

		return result;
	}

}