package Challenge.October1st_5;

class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {

		if(root==null)
			return new TreeNode(val);
		
		TreeNode node = root;

		while (true) {
			if (node.val < val)
				if (node.right == null) {
					node.right = new TreeNode(val);
					break;
				} else
					node = node.right;
			else if (node.left == null) {
				node.left = new TreeNode(val);
				break;
			} else
				node = node.left;

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