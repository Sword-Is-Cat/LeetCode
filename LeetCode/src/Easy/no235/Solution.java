package Easy.no235;

class Solution {

	TreeNode answer;
	int pp;
	int qq;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		pp = p.val;
		qq = q.val;
		
		process(root);

		return answer;
	}

	int process(TreeNode node) {

		if (node == null)
			return 0;

		int temp = (node.val == pp || node.val == qq) ? 1 : 0;

		temp += process(node.left) + process(node.right);

		if (temp == 2) {
			answer = node;
			return 0;
		}

		return temp;
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