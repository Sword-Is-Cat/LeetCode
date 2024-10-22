package Medium.no2583;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public long kthLargestLevelSum(TreeNode root, int k) {

		long answer = 0;

		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		PriorityQueue<Long> sums = new PriorityQueue<>(Collections.reverseOrder());

		while (!queue.isEmpty()) {

			int loop = queue.size();
			long sum = 0;
			while (loop-- > 0) {
				TreeNode node = queue.pollFirst();
				sum += node.val;
				if (node.left != null)
					queue.offerLast(node.left);
				if (node.right != null)
					queue.offerLast(node.right);
			}
			sums.offer(sum);

		}
		while (k-- > 0) {
			if (sums.isEmpty())
				return -1;
			answer = sums.poll();
		}

		return answer;
	}
}