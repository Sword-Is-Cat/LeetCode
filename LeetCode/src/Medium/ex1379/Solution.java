package Medium.ex1379;

class Solution {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

		TreeNode result = null;

		if (original == null)
			result = null;
		else if (original == target)
			result = cloned;
		else {

			result = getTargetCopy(original.left, cloned.left, target);
			if (result == null)
				result = getTargetCopy(original.right, cloned.right, target);
		}
		return result;
	}
}