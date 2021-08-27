package Easy.no108;

import java.util.Arrays;

class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {

		TreeNode node = null;
		int length = nums.length;

		if (length < 4) {

			TreeNode node1 = new TreeNode(nums[0]);

			if (length > 1) {

				TreeNode node2 = new TreeNode(nums[1]);
				node = node2;
				node.left = node1;

				if (length == 3) {

					node.right = new TreeNode(nums[2]);

				} else {
					node.right = null;
				}

			} else {
				node = node1;
				node.left = null;
				node.right = null;
			}

		} else {

			node = new TreeNode(nums[length / 2]);
			node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, length / 2));
			node.right = sortedArrayToBST(Arrays.copyOfRange(nums, length / 2 + 1, length));

		}

		return node;

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}