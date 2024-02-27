package Easy.no543;

class Solution {

	public int diameterOfBinaryTree(TreeNode root) {
		return getDepth(root)[1];
	}

	public int[] getDepth(TreeNode node) {

		int[] result = new int[2];

		if (node != null) {
			int[] left = getDepth(node.left), right = getDepth(node.right);
			result[0] = Math.max(left[0], right[0]) + 1;
			result[1] = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
		}
		return result;
	}
}