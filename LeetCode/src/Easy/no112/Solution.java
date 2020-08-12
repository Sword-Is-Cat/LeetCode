package Easy.no112;

class Solution {

	boolean answer = false;
	int sum;

	public boolean hasPathSum(TreeNode root, int sum) {

		this.sum = sum;

		process(root, 0);

		return answer;
	}

	void process(TreeNode node, int temp) {

		if (node == null || answer)
			return;
		else if (node.left == null && node.right == null) {
			if (temp + node.val == sum)
				answer = true;
		} else {
			process(node.left, temp + node.val);
			process(node.right, temp + node.val);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}