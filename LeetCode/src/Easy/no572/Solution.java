package Easy.no572;

class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		
		if (s == null && t == null)
			return true;
		else if (s == null || t == null)
			return false;
		else if(isSameTree(s, t))
			return true;
		else
			return isSubtree(s.left, t) || isSubtree(s.right, t); 
	}
	
	public boolean isSameTree(TreeNode node, TreeNode sub) {
		
		if (node == null && sub == null)
			return true;
		else if (node == null || sub == null)
			return false;
		else
			return node.val==sub.val && isSameTree(node.left, sub.left) && isSameTree(node.right, sub.right);
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