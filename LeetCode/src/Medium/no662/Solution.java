package Medium.no662;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int widthOfBinaryTree(TreeNode root) {

		Deque<TreeNode> prev, curr = new ArrayDeque<>();

		root.val = 1;
		curr.add(root);

		int maxLength = 1;

		while (!curr.isEmpty()) {

			prev = curr;
			curr = new ArrayDeque<>();

			while (!prev.isEmpty()) {

				TreeNode node = prev.poll();

				if (node.left != null) {
					curr.add(node.left);
					node.left.val = node.val * 2;
				}

				if (node.right != null) {
					curr.add(node.right);
					node.right.val = node.val * 2 + 1;
				}

			}

			if (!curr.isEmpty())
				maxLength = Math.max(maxLength, curr.peekLast().val - curr.peekFirst().val + 1);

		}

		return maxLength;

	}
}