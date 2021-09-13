package Easy.no563;

class Solution {
	
	int tilt = 0;
	public int findTilt(TreeNode root) {
		
		if(root==null)return tilt;
		process(root);
		return tilt;

	}
	
	public int process(TreeNode node) {
		if(node==null)return 0;
		int left = process(node.left);
		int right = process(node.right);
		tilt += Math.abs(left-right);
		return node.val+left+right;
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