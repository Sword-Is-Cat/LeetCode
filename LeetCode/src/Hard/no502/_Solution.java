package Hard.no502;

import java.util.Arrays;

class _Solution {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

		int length = profits.length;
		int[][] infos = new int[length][];

		for (int i = 0; i < length; i++) {
			infos[i] = new int[] { capital[i], profits[i] };
		}

		Arrays.sort(infos, (a, b) -> a[0] - b[0]);

		Node root = new Node(0, length - 1, infos);

		while (k-- > 0) {

			int head = -1, tail = length;
			while (head + 1 < tail) {
				int mid = (head + tail) / 2;
				if (infos[mid][0] <= w)
					head = mid;
				else
					tail = mid;
			}

			if (head == -1)
				break;
			Node max = findMaxNode(root, 0, head);
			if (max.value == -1)
				break;
			w += max.value;
			update(max, -1);

		}

		return w;
	}

	protected Node findMaxNode(Node node, int l, int r) {

		if (l < node.li || node.ri < r)
			return null;
		else if (l == node.li && r == node.ri)
			return getMaxNode(node);
		else if (r <= node.left.ri)
			return findMaxNode(node.left, l, r);
		else if (node.right.li <= l)
			return findMaxNode(node.right, l, r);
		else
			return comparing(findMaxNode(node.left, l, node.left.ri), findMaxNode(node.right, node.right.li, r));
	}

	protected Node getMaxNode(Node node) {
		if (node.maxNode == null) {
			node.maxNode = node.li == node.ri ? node : comparing(getMaxNode(node.left), getMaxNode(node.right));
		}
		return node.maxNode;
	}

	protected Node comparing(Node nodeA, Node nodeB) {
		return nodeA.value < nodeB.value ? nodeB : nodeA;
	}

	protected void update(Node node, int val) {
		if (node.li == node.ri) {
			node.value = val;
		} else {
			node.maxNode = null;
		}
		if (node.parent != null)
			update(node.parent, val);
	}
}

/**
 * define SegmentNode
 */
class Node {
	int li, ri, value;
	Node left, right, parent, maxNode;

	Node(int li, int ri, int[][] infos) {

		this.li = li;
		this.ri = ri;

		if (li == ri) {
			// leafNode
			value = infos[li][1];
		} else {
			int mid = (li + ri) / 2;
			left = new Node(li, mid, infos);
			left.parent = this;
			right = new Node(mid + 1, ri, infos);
			right.parent = this;
		}
	}
}