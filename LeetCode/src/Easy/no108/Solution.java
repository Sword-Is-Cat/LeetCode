package Easy.no108;

import java.util.Arrays;

class Solution {
	
	public TreeNode sortedArrayToBST(int[] nums) {

		TreeNode node = null;
		int length = nums.length;

		if (length > 3) {

			int idx = length / 2;
			node = new TreeNode(nums[idx]);
			node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, idx));
			node.right = sortedArrayToBST(Arrays.copyOfRange(nums, idx + 1, length));

		} else if (length > 1) {

			node = new TreeNode(nums[1]);
			node.left = new TreeNode(nums[0]);
			node.right = length == 3 ? new TreeNode(nums[2]) : null;

		} else if (length > 0) {

			node = new TreeNode(nums[0]);

		}

		return node;
	}
}