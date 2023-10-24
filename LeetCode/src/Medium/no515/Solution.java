package Medium.no515;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public List<Integer> largestValues(TreeNode root) {

		List<Integer> ans = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();

		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {

			int loop = queue.size(), value = queue.peek().val;

			while (loop-- > 0) {
				TreeNode node = queue.poll();
				value = Math.max(value, node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			ans.add(value);
		}
		return ans;
	}
}