package Medium.no116;

class Solution {
	public Node connect(Node root) {

		int depth = 0;

		while (connector(root, null, depth) != null)
			depth++;

		return root;
	}

	Node connector(Node node, Node prev, int depth) {

		if (depth == 0) {

			if (prev != null)
				prev.next = node;
			prev = node;

		} else {

			if (node.left != null)
				prev = connector(node.left, prev, depth - 1);

			if (node.right != null)
				prev = connector(node.right, prev, depth - 1);

		}
		return prev;
	}
}