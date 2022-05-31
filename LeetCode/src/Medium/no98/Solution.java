package Medium.no98;

class Solution {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	boolean isValid(TreeNode node, Integer min, Integer max) {

		if (node == null)
			return true;

		boolean rst = (min == null || node.val > min) && (max == null || node.val < max);
		rst &= isValid(node.left, min, node.val);
		rst &= isValid(node.right, node.val, max);

		return rst;
	}
}