package Medium.no117;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public Node connect(Node root) {

		List<Node> lefts = new ArrayList<>();

		append(lefts, root, 0);

		return root;
	}

	void append(List<Node> lefts, Node node, int depth) {

		if (node != null) {

			if (lefts.size() == depth)
				lefts.add(node);
			else {
				lefts.get(depth).next = node;
				lefts.set(depth, node);
			}

			append(lefts, node.left, depth + 1);
			append(lefts, node.right, depth + 1);
		}
	}
}