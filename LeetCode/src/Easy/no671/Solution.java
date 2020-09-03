package Easy.no671;

class Solution {

	int min = Integer.MAX_VALUE, answer = Integer.MAX_VALUE;
	boolean flag = true;

	public int findSecondMinimumValue(TreeNode root) {

		process(root);

		return flag ? -1 : answer;
	}

	void process(TreeNode node) {

		if (node == null)
			return;

		if (min >= node.val)
			min = node.val;
		else if (answer >= node.val) {
			answer = node.val;
			flag = false;
		}

		process(node.left);
		process(node.right);

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