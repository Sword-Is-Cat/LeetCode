package Medium.no114;

class Solution {

	public void flatten(TreeNode root) {

		if (root != null)
			flat(root);
	}

	// 해당 노드를 flatten시키고 endNode를 반환
	TreeNode flat(TreeNode node) {

		TreeNode tempL = node.left;
		TreeNode tempR = node.right;
		TreeNode temp = node;

		if (tempL != null) {

			temp = flat(tempL);
			temp.right = tempR;
			node.left = null;
			node.right = tempL;
		}

		if (tempR != null)
			temp = flat(tempR);

		return temp;

	}
}