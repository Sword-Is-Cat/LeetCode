package Easy.no1022;

class Solution {

	int answer = 0;

	public int sumRootToLeaf(TreeNode root) {
		sumBinary(0, root);
		return answer;
	}

	public void sumBinary(int sum, TreeNode node) {

		if (node == null)return;
		int score = sum * 2 + node.val;
		
		if(node.left==null && node.right==null) {
			answer+=score;
			return;
		}
		
		sumBinary(score, node.left);
		sumBinary(score, node.right);

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