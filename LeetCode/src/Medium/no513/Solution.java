package Medium.no513;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int answer = root.val;

		while (!queue.isEmpty()) {
			answer = queue.peek().val;
			int loop = queue.size();
			while (loop-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}

		return answer;
	}
}