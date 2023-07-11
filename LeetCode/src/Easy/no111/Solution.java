package Easy.no111;

import java.util.ArrayDeque;

class Solution {
	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		que.add(root);

		int depth = 1;

		while (!que.isEmpty()) {

			int loop = que.size();

			while (loop-- > 0) {

				TreeNode node = que.poll();

				if (node.left == null && node.right == null)
					return depth;
				else {
					if (node.left != null)
						que.add(node.left);
					if (node.right != null)
						que.add(node.right);
				}
			}
			depth++;
		}
		return depth;

	}
}