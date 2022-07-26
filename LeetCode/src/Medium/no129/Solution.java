package Medium.no129;

class Solution {

	int ans = 0;

	public int sumNumbers(TreeNode root) {

		if (root != null)
			process(root, 0);

		return ans;
	}

	void process(TreeNode node, int sum) {

		sum = sum * 10 + node.val;

		if (node.left == null && node.right == null) {
			ans += sum;
		} else {

			if (node.left != null)
				process(node.left, sum);

			if (node.right != null)
				process(node.right, sum);

		}

	}

}