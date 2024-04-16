package Medium.no623;

import java.util.ArrayDeque;

class Solution {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {

		if (depth == 1) {
			return new TreeNode(val, root, null);
		}

		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (depth-- > 2) {
			int loop = queue.size();
			while (loop-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			node.left = new TreeNode(val, node.left, null);
			node.right = new TreeNode(val, null, node.right);
		}

		return root;

	}
}