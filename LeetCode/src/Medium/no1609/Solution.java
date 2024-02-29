package Medium.no1609;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public boolean isEvenOddTree(TreeNode root) {

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int level = -1;

		while (!queue.isEmpty()) {

			level++;

			int prev = queue.peek().val + (level % 2 == 0 ? -1 : 1);
			int loop = queue.size();

			while (loop-- > 0) {
				TreeNode node = queue.poll();

				if (level % 2 == 0 && (node.val % 2 == 0 || prev >= node.val))
					return false;

				if (level % 2 == 1 && (node.val % 2 == 1 || prev <= node.val))
					return false;

				prev = node.val;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

		}

		return true;
	}
}