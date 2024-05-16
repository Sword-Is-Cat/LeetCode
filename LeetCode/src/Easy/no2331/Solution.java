package Easy.no2331;

class Solution {
	public boolean evaluateTree(TreeNode root) {
		switch (root.val) {
		case 1:
			return true;
		case 2:
			return evaluateTree(root.left) || evaluateTree(root.right);
		case 3:
			return evaluateTree(root.left) && evaluateTree(root.right);
		default:
			return false;
		}
	}
}