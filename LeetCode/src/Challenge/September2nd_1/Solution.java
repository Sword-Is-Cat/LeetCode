package Challenge.September2nd_1;

class Solution {

	int answer;

	public int sumRootToLeaf(TreeNode root) {

		process(root, 0);
		return answer;
	}

	void process(TreeNode node, int val) {

		if (node == null)
			return;

		val = val * 2 + node.val;

		if (node.left == null && node.right == null)
			answer += val;
		else {
			process(node.left, val);
			process(node.right, val);
		}

		return;
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