package Medium.no236;

class Solution {

	TreeNode answer;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		process(root, p, q);

		return answer;
	}

	int process(TreeNode node, TreeNode p, TreeNode q) {

		int result = 0;

		if (answer == null) {

			if (node.equals(p))
				result = 1;
			else if (node.equals(q))
				result = 2;

			if (node.left != null)
				result += process(node.left, p, q);

			if (node.right != null)
				result += process(node.right, p, q);

			if (answer == null && result == 3)
				answer = node;
		}

		return result;
	}
}