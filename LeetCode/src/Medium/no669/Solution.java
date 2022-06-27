package Medium.no669;

class Solution {

	public TreeNode trimBST(TreeNode root, int low, int high) {

		if (root != null) {

			if (root.val < low) {
				root = trimBST(root.right, low, high);
			} else if (root.val > high) {
				root = trimBST(root.left, low, high);
			} else {
				root.left = trimBST(root.left, low, high);
				root.right = trimBST(root.right, low, high);
			}
		}
		return root;
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