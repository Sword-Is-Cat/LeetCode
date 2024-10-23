package Medium.no2641;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public TreeNode replaceValueInTree(TreeNode root) {
		root.val = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			int childDepthSum = 0;
			int loop = queue.size();
			for (int i = 0; i < loop; i++) {
				TreeNode node = queue.poll();
				childDepthSum += getChildSum(node);
				queue.offer(node);
			}
			for (int i = 0; i < loop; i++) {
				TreeNode node = queue.poll();
				int childSum = getChildSum(node);
				if (node.left != null) {
					node.left.val = childDepthSum - childSum;
					queue.offer(node.left);
				}
				if (node.right != null) {
					node.right.val = childDepthSum - childSum;
					queue.offer(node.right);
				}
			}

		}

		return root;
	}

	private int getChildSum(TreeNode node) {
		int result = 0;
		if (node.left != null)
			result += node.left.val;
		if (node.right != null)
			result += node.right.val;
		return result;
	}
}