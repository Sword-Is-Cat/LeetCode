package Easy.no700;

class Solution {
	public TreeNode searchBST(TreeNode root, int val) {

		if (root == null || root.val == val)
			return root;
		else
			return searchBST(root.val > val ? root.left : root.right, val);

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
