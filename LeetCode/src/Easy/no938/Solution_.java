package Easy.no938;

class Solution_ {
	public int rangeSumBST(TreeNode root, int low, int high) {

		if (root == null)
			return 0;

		int result = rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

		if (low <= root.val && root.val <= high)
			result += root.val;

		return result;
	}
}