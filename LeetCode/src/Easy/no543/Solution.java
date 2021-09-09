package Easy.no543;

class Solution {
	
	int diameter = 0;
	public int diameterOfBinaryTree(TreeNode root) {

		if(root==null)return diameter;
		process(root);
		return diameter;
	}
	
	public int process(TreeNode node) {
		
		if(node==null)return 0;
		
		int left = process(node.left);
		int right = process(node.right);
		diameter = Math.max(diameter, left+right);
		return Math.max(left, right)+1;
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