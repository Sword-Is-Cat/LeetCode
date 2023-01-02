package Medium.no106;

import java.util.Arrays;

class Solution {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || inorder.length == 0)
			return null;

		int length = inorder.length, value = postorder[length - 1], idx = 0;

		while (idx < length) {
			if (inorder[idx] == value)
				break;
			idx++;
		}

		TreeNode node = new TreeNode(value);
		node.left = buildTree(Arrays.copyOfRange(inorder, 0, idx), Arrays.copyOfRange(postorder, 0, idx));
		node.right = buildTree(Arrays.copyOfRange(inorder, idx + 1, length),
				Arrays.copyOfRange(postorder, idx, length - 1));

		return node;
	}
}