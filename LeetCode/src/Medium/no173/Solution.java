package Medium.no173;

import java.util.PriorityQueue;
import java.util.Queue;

class BSTIterator {

	Queue<TreeNode> queue;

	public BSTIterator(TreeNode root) {

		queue = new PriorityQueue<TreeNode>((a, b) -> a.val - b.val);
		initialize(root);

	}

	public int next() {
		return hasNext() ? queue.poll().val : -1;
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	void initialize(TreeNode node) {
		if (node != null) {
			queue.add(node);
			initialize(node.left);
			initialize(node.right);
		}
	}
}