package Medium.no889;

import java.util.Arrays;

class Solution {
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

		TreeNode node = null;

		if (preorder.length > 0) {

			node = new TreeNode(preorder[0]);

			if (preorder.length > 1) {

				int length = indexOf(postorder, preorder[1]) + 1;
				node.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, 1 + length),
						Arrays.copyOfRange(postorder, 0, length));
				node.right = constructFromPrePost(Arrays.copyOfRange(preorder, 1 + length, preorder.length),
						Arrays.copyOfRange(postorder, length, postorder.length - 1));

			}

		}

		return node;

	}

	private int indexOf(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
