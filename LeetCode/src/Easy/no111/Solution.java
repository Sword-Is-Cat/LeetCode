package Easy.no111;

class Solution {

	int answer = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		
		if(root==null)
			return 0;

		process(root, 1);

		return answer;
	}

	void process(TreeNode node, int depth) {

		if (node == null)
			return;
		else if (node.left == null && node.right == null)
			answer = Math.min(answer, depth);
		else {
			process(node.left, depth + 1);
			process(node.right, depth + 1);
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