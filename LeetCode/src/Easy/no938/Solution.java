package Easy.no938;

class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {

		if (root == null)
			return 0;

		int result = low <= root.val && root.val <= high ? root.val : 0;

		if (low <= root.val)
			result += rangeSumBST(root.left, low, high);

		if (root.val <= high)
			result += rangeSumBST(root.right, low, high);

		return result;

	}
}